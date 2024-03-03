package com.ruftech.course_work;

import com.ruftech.course_work.db_data.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class SellerController {

    @FXML
    private AnchorPane aircraft;

    @FXML
    private TableColumn<Aircraft, Integer> aircraftCommanderNumber;

    @FXML
    private TextField aircraftCommanderNumberField;

    @FXML
    private Button aircraftFetchOriginButton;

    @FXML
    private TableColumn<Aircraft, Integer> aircraftIsReady;

    @FXML
    private TextField aircraftIsReadyField;

    @FXML
    private TableColumn<Aircraft, Integer> aircraftLifeTime;

    @FXML
    private TextField aircraftLifeTimeField;

    @FXML
    private TableColumn<Aircraft, Date> aircraftManufactureDate;

    @FXML
    private TextField aircraftManufactureDateField;

    @FXML
    private TableColumn<Aircraft, String> aircraftModel;

    @FXML
    private TextField aircraftModelField;

    @FXML
    private Button aircraftSearchButton;

    @FXML
    private TableView<Aircraft> aircraftTable;

    @FXML
    private TableColumn<Aircraft, String> aircraftTailNumber;

    @FXML
    private TextField aircraftTailNumberField;

    @FXML
    private AnchorPane commander;

    @FXML
    private TableView<Commander> commanderTable;

    @FXML
    private TableColumn<Commander, String> commanderAddress;

    @FXML
    private TextField commanderAddressField;

    @FXML
    private Button commanderFetchOriginButton;

    @FXML
    private TableColumn<Commander, String> commanderFirstname;

    @FXML
    private TextField commanderFirstnameField;

    @FXML
    private TableColumn<Commander, Double> commanderFlyingHours;

    @FXML
    private TextField commanderFlyingHoursField;

    @FXML
    private TableColumn<Commander, String> commanderLastname;

    @FXML
    private TextField commanderLastnameField;

    @FXML
    private TableColumn<Commander, Integer> commanderPersonalNumber;

    @FXML
    private TextField commanderPersonalNumberField;

    @FXML
    private TableColumn<Commander, String> commanderPhone;

    @FXML
    private TextField commanderPhoneField;

    @FXML
    private Button commanderSearchButton;

    @FXML
    private AnchorPane flight;


    @FXML
    private TableColumn<Flight, String> flightAircraftTailNumber;

    @FXML
    private TextField flightAircraftTailNumberField;

    @FXML
    private TableColumn<Flight, Timestamp> flightDepartureTime;

    @FXML
    private TextField flightDepartureTimeField;


    @FXML
    private Button flightFetchOriginButton;

    @FXML
    private TableColumn<Flight, Integer> flightIsCanceled;

    @FXML
    private TextField flightIsCanceledField;

    @FXML
    private TableColumn<Flight, String > flightNumber;

    @FXML
    private TextField flightNumberField;

    @FXML
    private TableColumn<Flight, String> flightRouteNumber;

    @FXML
    private TextField flightRouteNumberField;

    @FXML
    private TableView<Flight> flightTable;

    @FXML
    private Button flightSearchButton;


    @FXML
    private TabPane main;

    @FXML
    private AnchorPane onboardPassenger;

    @FXML
    private Button onboardPassengerAddButton;

    @FXML
    private Button onboardPassengerFetchOriginButton;

    @FXML
    private ListView<String> onboardPassengerFlightsList;

    @FXML
    private ListView<String> onboardPassengerList;

    @FXML
    private Button onboardPassengerRemoveButton;

    @FXML
    private Button onboardPassengerShowButton;

    @FXML
    private AnchorPane passenger;

    @FXML
    private Button passengerAddButton;

    @FXML
    private TableColumn<Passenger, String> passengerAddress;

    @FXML
    private TextField passengerAddressField;

    @FXML
    private Button passengerDeleteButton;

    @FXML
    private Button passengerFetchOriginButton;

    @FXML
    private Button passengerEditButton;

    @FXML
    private TableColumn<Passenger, String> passengerFirstname;

    @FXML
    private TextField passengerFirstnameField;

    @FXML
    private TableColumn<Passenger, String> passengerLastname;

    @FXML
    private TextField passengerLastnameField;

    @FXML
    private TableColumn<Passenger, String> passengerPassport;

    @FXML
    private TextField passengerPassportField;

    @FXML
    private TableColumn<Passenger, String> passengerPhone;

    @FXML
    private TextField passengerPhoneField;

    @FXML
    private Button passengerSearchButton;

    @FXML
    private TableView<Passenger> passengerTable;

    @FXML
    private AnchorPane route;

    @FXML
    private TableColumn<Route, String> routeArrival;

    @FXML
    private TextField routeArrivalField;

    @FXML
    private TableColumn<Route, String> routeDeparture;

    @FXML
    private TextField routeDepartureField;

    @FXML
    private TableColumn<Route, Integer> routeDuration;

    @FXML
    private TextField routeDurationField;

    @FXML
    private Button routeFetchOriginButton;

    @FXML
    private TableColumn<Route, String> routeNumber;

    @FXML
    private TextField routeNumberField;

    @FXML
    private TableColumn<Route, Double> routePrice;

    @FXML
    private TextField routePriceField;


    @FXML
    private Button routeSearchButton;

    @FXML
    private TableView<Route> routeTable;

    @FXML
    private AnchorPane showIncome;

    @FXML
    private Button showIncomeButton;

    @FXML
    private TextField showIncomeYearField;

    @FXML
    private TableView<Income> incomeTable;

    @FXML
    private TableColumn<Income, String> incomeCol1;

    @FXML
    private TableColumn<Income, String> incomeCol2;

    @FXML
    private TableColumn<Income, String> incomeCol3;


    private DataBase dataBase;
    private User user;

    /*
    ФУНКЦИИ ДЛЯ СОЗДАНИЯ ОТЧЕТА О ДОХОДАХ
     */
    public void showIncome(String year) {
        incomeTable.setSortPolicy(null);
        try {
            incomeCol1.setCellValueFactory(new PropertyValueFactory<>("value1"));
            incomeCol2.setCellValueFactory(new PropertyValueFactory<>("value2"));
            incomeCol3.setCellValueFactory(new PropertyValueFactory<>("value3"));

            ObservableList<Income> incomes = FXCollections.observableArrayList();

            ResultSet rf = dataBase.statement.executeQuery("call show_profit(" + year + ");");

            while (rf.next()) {
                String val1 = rf.getString(1);
                String val2 = rf.getString(2);
                String val3 = rf.getString(3);
                incomes.add(new Income(val1, val2, val3));
            }
            incomeTable.setItems(incomes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    /*
    ФУНКЦИИ ДЛЯ ПОСАДКИ ПАССАЖИРОВ
     */

    public void fetchOnboard(){
        try {
            ObservableList<String> flights = FXCollections.observableArrayList();

            ResultSet rf = dataBase.statement.executeQuery("SELECT * FROM flight;");
            while (rf.next()) {
                String flightNumber = rf.getString(1);
//                System.out.println(flightNumber);
                flights.add(flightNumber);
            }
            onboardPassengerFlightsList.setItems(flights);

            ObservableList<String> passenger = FXCollections.observableArrayList();

            ResultSet rp = dataBase.statement.executeQuery("SELECT * FROM passenger;");

            while (rp.next()) {
                String passport = rp.getString(1);
//                System.out.println(passport);
                passenger.add(passport);
            }
            onboardPassengerList.setItems(passenger);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addOnboard(String flight, String passenger) {
        try {
            String query = "INSERT INTO flight_has_passenger (passenger_passport, flight_number) VALUE " +
                    "(\"" + passenger +
                    "\", \"" + flight +
                    "\");";

            dataBase.statement.execute(query);
            query =  "UPDATE flight SET is_canceled = 0 where number = \"" + flight + "\";";
//            System.out.println(query);
            dataBase.statement.execute(query);
            fetchAllData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteOnboard(String flight, String passenger) {
        try {
            String query = "DELETE FROM flight_has_passenger where flight_number = \""+flight+"\" AND passenger_passport = \""
                    + passenger + "\";";

            dataBase.statement.execute(query);

            dataBase.statement.execute("{call check_flight(\"" + flight + "\")}");
            fetchAllData();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void showOnboard(String flight) {
        try {
            String query = "SELECT * FROM flight_has_passenger where flight_number = \"" + flight + "\"";

            ResultSet rs = dataBase.statement.executeQuery(query);

            ObservableList<String> passenger = FXCollections.observableArrayList();

            while(rs.next()) {
                passenger.add(rs.getString(1));
            }
            onboardPassengerList.getItems().setAll(passenger);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    /*
    ФУНКЦИИ ДЛЯ РАБОТЫ С РЕЙСАМИ
     */
    public void fetchFlights() {
        try {
//            INITIALIZE COLUMNS
            flightNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
            flightDepartureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
            flightIsCanceled.setCellValueFactory((new PropertyValueFactory<>("isCanceled")));
            flightRouteNumber.setCellValueFactory(new PropertyValueFactory<>("routeNumber"));
            flightAircraftTailNumber.setCellValueFactory(new PropertyValueFactory<>("aircraftTailNumber"));

            ObservableList<Flight> flights = FXCollections.observableArrayList();

            ResultSet rs = dataBase.statement.executeQuery("SELECT * FROM flight;");
            while (rs.next()) {
                String number = rs.getString(1);
                Timestamp departureTime = rs.getTimestamp(2);
                int isCanceled = rs.getInt(3);
                String routeNumber = rs.getString(4);
                String aircraftTailNumber = rs.getString(5);
                flights.add(new Flight(number, departureTime, isCanceled, routeNumber, aircraftTailNumber));
            }
            flightTable.setItems(flights);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchFlight(String number, String departureTime, String isCanceled, String routeNumber, String aircraftTailNumber) {
        try {
//            INITIALIZE COLUMNS
            flightNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
            flightDepartureTime.setCellValueFactory(new PropertyValueFactory<>("departureTime"));
            flightIsCanceled.setCellValueFactory((new PropertyValueFactory<>("isCanceled")));
            flightRouteNumber.setCellValueFactory(new PropertyValueFactory<>("routeNumber"));
            flightAircraftTailNumber.setCellValueFactory(new PropertyValueFactory<>("aircraftTailNumber"));

            ObservableList<Flight> flights = FXCollections.observableArrayList();


            String query = "SELECT * FROM flight where 1 = 1 ";

            if (number != null && !number.isEmpty()) {
                query += "AND number = \"" + number + "\" ";
            }
            if (departureTime != null && !departureTime.isEmpty()) {
                if (InputMask.isValidTimestmap(departureTime)) {
                    query += "AND departure_time = \"" + departureTime + "\" ";
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "Departure time is not correct");
                }
//                query += "AND model = \"" + model + "\" ";
            }
            if (isCanceled != null && !isCanceled.isEmpty()) {
                if (InputMask.isValidReady(isCanceled)) {
                    if(Integer.parseInt(isCanceled) >= 0) {
                        query += "AND is_canceled = " + isCanceled + " ";
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "isReady is should be a integer");
                }
            }
            if (routeNumber != null && !routeNumber.isEmpty()) {
                query += "AND route_number = \"" + routeNumber + "\" ";
            }
            if (aircraftTailNumber != null && !aircraftTailNumber.isEmpty()) {
                query += "AND aircraft_tail_number = \"" + aircraftTailNumber + "\" ";
            }
            query += ";";
//            System.out.println(query);
            ResultSet rs = dataBase.statement.executeQuery(query);
            while (rs.next()) {
                number = rs.getString(1);
                Timestamp fdt = rs.getTimestamp(2);
                int fic= rs.getInt(3);
                routeNumber = rs.getString(4);
                aircraftTailNumber = rs.getString(5);
                flights.add(new Flight(number, fdt, fic, routeNumber, aircraftTailNumber));
            }
            flightTable.setItems(flights);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearFlightFields() {
        flightNumberField.clear();
        flightDepartureTimeField.clear();
        flightIsCanceledField.clear();
        flightRouteNumberField.clear();
        flightAircraftTailNumberField.clear();
    }

    /*
    ФУНКЦИИ ДЛЯ РАБОТЫ С САМОЛЕТАМИ
     */
    public void fetchAircraft() {
        try {
//            INITIALIZE COLUMNS
            aircraftTailNumber.setCellValueFactory(new PropertyValueFactory<>("tailNumber"));
            aircraftModel.setCellValueFactory(new PropertyValueFactory<>("model"));
            aircraftManufactureDate.setCellValueFactory(new PropertyValueFactory<>("manufactureDate"));
            aircraftLifeTime.setCellValueFactory(new PropertyValueFactory<>("lifetime"));
            aircraftIsReady.setCellValueFactory(new PropertyValueFactory<>("isReady"));
            aircraftCommanderNumber.setCellValueFactory(new PropertyValueFactory<>("commanderPersonalNumber"));

            ObservableList<Aircraft> aircrafts = FXCollections.observableArrayList();

            ResultSet rs = dataBase.statement.executeQuery("SELECT * FROM aircraft;");
            while (rs.next()) {
                String tailNumber = rs.getString(1);
                String model = rs.getString(2);
                Date manufactureDate = rs.getDate(3);
                int lifetime = rs.getInt(4);
                int isReady = rs.getInt(5);
                int commanderNumber = rs.getInt(6);
                aircrafts.add(new Aircraft(tailNumber, model,manufactureDate, lifetime,isReady, commanderNumber));
            }
            aircraftTable.setItems(aircrafts);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchAircraft(String tailNumber, String model, String manufactureDate, String  lifetime, String isReady, String commanderNumber) {
        try {
//            INITIALIZE COLUMNS
            aircraftTailNumber.setCellValueFactory(new PropertyValueFactory<>("tailNumber"));
            aircraftModel.setCellValueFactory(new PropertyValueFactory<>("model"));
            aircraftManufactureDate.setCellValueFactory(new PropertyValueFactory<>("manufactureDate"));
            aircraftLifeTime.setCellValueFactory(new PropertyValueFactory<>("lifetime"));
            aircraftIsReady.setCellValueFactory(new PropertyValueFactory<>("isReady"));
            aircraftCommanderNumber.setCellValueFactory(new PropertyValueFactory<>("commanderPersonalNumber"));

            ObservableList<Aircraft> aircrafts = FXCollections.observableArrayList();


            String query = "SELECT * FROM aircraft where 1 = 1 ";

            if (tailNumber != null && !tailNumber.isEmpty()) {
                query += "AND tail_number = \"" + tailNumber + "\" ";
            }
            if (model != null && !model.isEmpty()) {
                query += "AND model = \"" + model + "\" ";
            }
            if (manufactureDate != null && !manufactureDate.isEmpty()) {
                if (InputMask.isValidDate(manufactureDate)){
                    query += "AND manufacture_date = DATE \"" + manufactureDate + "\" ";
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "Date is not correct");
                }
            }
            if (lifetime != null && !lifetime.isEmpty()) {
                if (InputMask.isValidInt(lifetime)) {
                    if(Integer.parseInt(lifetime) >= 0) {
                        query += "AND lifetime = " + lifetime + " ";
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "Lifetime is should be a integer");
                }
            }
            if (isReady != null && !isReady.isEmpty()) {
                if (InputMask.isValidInt(isReady)) {
                    if(Integer.parseInt(isReady) >= 0) {
                        query += "AND is_ready = " + isReady + " ";
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "isReady is should be a integer");
                }
            }
            if (commanderNumber != null && !commanderNumber.isEmpty()) {
                if (InputMask.isValidInt(commanderNumber)) {
                    if(Integer.parseInt(commanderNumber) >= 0) {
                        query += "AND commander_personal_number = " + commanderNumber + " ";
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "Commander personal number is should be a integer");
                }
            }
            query += ";";
//            System.out.println(query);
            ResultSet rs = dataBase.statement.executeQuery(query);
            while (rs.next()) {
                tailNumber = rs.getString(1);
                model = rs.getString(2);
                Date amd = rs.getDate(3);
                int al = rs.getInt(4);
                int air = rs.getInt(5);
                int acn = rs.getInt(6);
                aircrafts.add(new Aircraft(tailNumber, model, amd, al, air, acn));
            }
            aircraftTable.setItems(aircrafts);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearAircraftFields() {
        aircraftTailNumberField.clear();
        aircraftModelField.clear();
        aircraftManufactureDateField.clear();
        aircraftLifeTimeField.clear();
        aircraftIsReadyField.clear();
        aircraftCommanderNumberField.clear();
    }

    /*
    ФУНКЦИИ ДЛЯ РАБОТЫ С ПАССАЖИРАМИ
     */

    public void fetchPassengers() {
        try {
//            INITIALIZE COLUMNS

            passengerPassport.setCellValueFactory(new PropertyValueFactory<>("passport"));
            passengerLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            passengerFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            passengerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            passengerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));

            ObservableList<Passenger> passengers = FXCollections.observableArrayList();

            ResultSet rs = dataBase.statement.executeQuery("SELECT * FROM passenger;");
            while (rs.next()) {
                String passport = rs.getString(1);
                String lastname = rs.getString(2);
                String firstname = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                passengers.add(new Passenger(passport, lastname, firstname, address, phone));
            }
            passengerTable.setItems(passengers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchPassenger(String passport, String lastname, String firstname, String address, String phone) {
        try {
//            INITIALIZE COLUMNS
            passengerPassport.setCellValueFactory(new PropertyValueFactory<>("passport"));
            passengerLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            passengerFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            passengerAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            passengerPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));


            ObservableList<Passenger> passengers = FXCollections.observableArrayList();

            String query = "SELECT * FROM passenger where 1 = 1 ";

            if (phone != null && !phone.isEmpty()) {
                query += "AND passport = \"" + passport + "\" ";
            }
            if (lastname != null && !lastname.isEmpty()) {
                query += "AND lastname = \"" + lastname + "\" ";
            }
            if (firstname != null && !firstname.isEmpty()) {
                query += "AND firstname = \"" + firstname + "\" ";
            }
            if (address != null && !address.isEmpty()) {
                query += "AND address = \"" + address + "\" ";
            }
            if (phone != null && !phone.isEmpty()) {
                query += "AND phone = \"" + phone + "\" ";
            }
            query += ";";
//            System.out.println(query);
            ResultSet rs = dataBase.statement.executeQuery(query);
            while (rs.next()) {
                passport = rs.getString(1);
                lastname = rs.getString(2);
                firstname = rs.getString(3);
                address = rs.getString(4);
                phone = rs.getString(5);
                passengers.add(new Passenger(passport, lastname, firstname, address, phone));
            }
            passengerTable.setItems(passengers);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void addPassenger(String passport, String lastname, String firstname, String address, String phone) {
        if(InputMask.isValidPassenger(passport, lastname, firstname, address, phone)) {
            try {
                String query = "INSERT INTO passenger (passport, lastname, firstname, address, phone) VALUE (" +
                        "\"" + passport + "\", " +
                        "\"" + lastname +"\", " +
                        "\"" + firstname +"\", " +
                        "\"" + address +"\", " +
                        "\"" + phone +"\"" +
                        ");";

                dataBase.statement.execute(query);

                fetchPassengers();
            } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
                AlertUtils.showErrorAlert("Error", "Error", throwables.getMessage());
            }
        }
        else {
            AlertUtils.showErrorAlert("Error", "Error", "Passenger is not correct");
        }
    }
    public void showSelectedPassenger(MouseEvent event) {
        if (passengerTable.getSelectionModel().isEmpty())
            return;
        int passengerIndex = passengerTable.getSelectionModel().getSelectedIndex();
        passengerPassportField.setText(passengerPassport.getCellData(passengerIndex));
        passengerLastnameField.setText(passengerLastname.getCellData(passengerIndex));
        passengerFirstnameField.setText(passengerFirstname.getCellData(passengerIndex));
        passengerAddressField.setText(passengerAddress.getCellData(passengerIndex));
        passengerPhoneField.setText(passengerPhone.getCellData(passengerIndex));
    }

    public void editPassenger(String passport, String lastname, String firstname, String address, String phone) {
        if (InputMask.isValidPassenger(passport, lastname, firstname, address, phone)) {
            try {
                String query = "UPDATE passenger SET " +
                        "passport = \"" + passport + "\", " +
                        "lastname = \"" + lastname + "\", " +
                        "firstname = \"" + firstname + "\", " +
                        "address = \"" + address + "\", " +
                        "phone =  \"" + phone + "\"" +
                         " WHERE passport = \"" + passengerTable.getSelectionModel().getSelectedItem().getPassport() + "\";";

//                System.out.println(query);
                dataBase.statement.execute(query);

                fetchPassengers();
            } catch (SQLException throwables) {
//            throwables.printStackTrace();
//            throw new RuntimeException();
                AlertUtils.showErrorAlert("Error", "Error", throwables.getMessage());
            }
        } else {
            AlertUtils.showErrorAlert("Error", "Error", "Passenger is not correct");
        }
    }
    public void clearPassengerFields() {
        passengerPassportField.clear();
        passengerLastnameField.clear();
        passengerFirstnameField.clear();
        passengerAddressField.clear();
        passengerPhoneField.clear();
    }

    /*
    ФУНКЦИИ ДЛЯ РАБОТЫ С КОММАНДИРАМИ ВОЗДУШНЦЫХ СУДОВ
     */
    public void fetchCommanders() {
        try {
//            INITIALIZE COLUMNS

            commanderPersonalNumber.setCellValueFactory(new PropertyValueFactory<>("personalNumber"));
            commanderLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            commanderFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            commanderAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            commanderPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            commanderFlyingHours.setCellValueFactory(new PropertyValueFactory<>("flyingHours"));

            ObservableList<Commander> commanders = FXCollections.observableArrayList();

            ResultSet rs = dataBase.statement.executeQuery("SELECT * FROM commander;");
            while (rs.next()) {
                int personalNumber = rs.getInt(1);
                String lastname = rs.getString(2);
                String firstname = rs.getString(3);
                String address = rs.getString(4);
                String phone = rs.getString(5);
                double flyingHours = rs.getDouble(6);
                commanders.add(new Commander(personalNumber, lastname, firstname, address, phone, flyingHours));
            }
            commanderTable.setItems(commanders);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void searchCommander(String personalNumber, String lastname, String firstname, String address, String phone, String flyingHours) {
        try {
//            INITIALIZE COLUMNS
            commanderPersonalNumber.setCellValueFactory(new PropertyValueFactory<>("personalNumber"));
            commanderLastname.setCellValueFactory(new PropertyValueFactory<>("lastname"));
            commanderFirstname.setCellValueFactory(new PropertyValueFactory<>("firstname"));
            commanderAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
            commanderPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
            commanderFlyingHours.setCellValueFactory(new PropertyValueFactory<>("flyingHours"));


            ObservableList<Commander> commanders = FXCollections.observableArrayList();

            String query = "SELECT * FROM commander where 1 = 1 ";

            if(!personalNumber.isEmpty()) {
                if(InputMask.isValidInt(personalNumber)) {
                    if (Integer.parseInt(personalNumber) >= -1) {
                        query += "AND personal_number = \"" + personalNumber + "\" ";
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "Personal Number is should be a integer");
                }
            }

            if (lastname != null && !lastname.isEmpty()) {
                query += "AND lastname = \"" + lastname + "\" ";
            }
            if (firstname != null && !firstname.isEmpty()) {
                query += "AND firstname = \"" + firstname + "\" ";
            }
            if (address != null && !address.isEmpty()) {
                query += "AND address = \"" + address + "\" ";
            }
            if (phone != null && !phone.isEmpty()) {
                query += "AND phone = \"" + phone + "\" ";
            }
            if (!flyingHours.isEmpty()) {
                if(InputMask.isValidDouble(flyingHours)) {
                    if (Double.parseDouble(flyingHours) >= 0) {
                        query += " AND flying_hours = " + flyingHours;
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "This is not a double");
                }
            }
            query += ";";
//            System.out.println(query);
            ResultSet rs = dataBase.statement.executeQuery(query);
            while (rs.next()) {
                int pn = rs.getInt(1);
                lastname = rs.getString(2);
                firstname = rs.getString(3);
                address = rs.getString(4);
                phone = rs.getString(5);
                double fh = rs.getDouble(6);
                commanders.add(new Commander(pn, lastname, firstname, address, phone, fh));
            }
            commanderTable.setItems(commanders);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void clearCommanderFields() {
        commanderPersonalNumberField.clear();
        commanderLastnameField.clear();
        commanderFirstnameField.clear();
        commanderAddressField.clear();
        commanderPhoneField.clear();
        commanderFlyingHoursField.clear();
    }

    /*
    ФУНКЦИИ ДЛЯ РАБОТЫ С МАРШРУТАМИ
     */
    public void fetchRoutes() {
        try {
//            INITIALIZE COLUMNS
            routeNumber.setCellValueFactory(new PropertyValueFactory<>("routeNumber"));
            routeDeparture.setCellValueFactory(new PropertyValueFactory<>("departure"));
            routeArrival.setCellValueFactory(new PropertyValueFactory<>("arrival"));
            routePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            routeDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

            ObservableList<Route> routes = FXCollections.observableArrayList();

            ResultSet rs = dataBase.statement.executeQuery("SELECT * FROM route;");
            while (rs.next()) {
                String routeNumber = rs.getString(1);
                String departure = rs.getString(2);
                String arrival = rs.getString(3);
                double price = rs.getDouble(4);
                int duration = rs.getInt(5);
                routes.add(new Route(routeNumber, departure, arrival, price, duration));
            }
            routeTable.setItems(routes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void searchRoutes(String number, String departure, String arrival, String price, String duration) {
        try {
//            INITIALIZE COLUMNS
            routeNumber.setCellValueFactory(new PropertyValueFactory<>("routeNumber"));
            routeDeparture.setCellValueFactory(new PropertyValueFactory<>("departure"));
            routeArrival.setCellValueFactory(new PropertyValueFactory<>("arrival"));
            routePrice.setCellValueFactory(new PropertyValueFactory<>("price"));
            routeDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

            ObservableList<Route> routes = FXCollections.observableArrayList();

            String query = "SELECT * FROM route where 1 = 1 ";

            if (number != null && !number.isEmpty()) {
                query += "AND number = \"" + number + "\" ";
            }

            if (departure != null && !departure.isEmpty()) {
                query += "AND departure = \"" + departure + "\" ";
            }
            if (arrival != null && !arrival.isEmpty()) {
                query += "AND arrival = \"" + arrival + "\" ";
            }
            if (!price.isEmpty()) {
                if(InputMask.isValidDouble(price)) {
                    if (Double.parseDouble(price) >= 0) {
                        query += " AND price = " + price;
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "This is not a double");
                }
            }
            if(!duration.isEmpty()) {
                if(InputMask.isValidInt(duration)) {
                    if (Integer.parseInt(duration) >= 0) {
                        query += " AND duration = " + duration;
                    }
                }
                else {
                    AlertUtils.showErrorAlert("Error", "Error", "This is not a integer");
                }
            }
            query += ";";
//            System.out.println(query);

            ResultSet rs = dataBase.statement.executeQuery(query);

            while (rs.next()) {
                String routeNumber = rs.getString(1);
                departure = rs.getString(2);
                arrival = rs.getString(3);
                double p = rs.getDouble(4);
                int dur = rs.getInt(5);
                routes.add(new Route(routeNumber, departure, arrival, p, dur));
            }
            routeTable.setItems(routes);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void clearRouteFields() {
        routeNumberField.clear();
        routeArrivalField.clear();
        routeDepartureField.clear();
        routePriceField.clear();
        routeDurationField.clear();
    }
    void fetchAllData() {
        fetchRoutes();
        fetchCommanders();
        fetchFlights();
        fetchPassengers();
        fetchAircraft();
        fetchOnboard();
    }
    @FXML
    void initialize() {
//        System.out.println(this.user);
        user = deserializeUserData();
//        System.out.println(this.user);
        dataBase = new DataBase(user);
        try {
            if(dataBase.connection.isValid(Connection.TRANSACTION_SERIALIZABLE)) {
                fetchAllData();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        /*
        ВЫЗОВЫ ДЛЯ ОТЧЕТА О ДОХОДАХ ЗА ГОД
         */
        showIncomeButton.setOnAction(e -> {
            fetchAllData();
            String year = showIncomeYearField.getText();
            if (InputMask.isValidYear(year)) {
                showIncome(year);
            }
            else {
                AlertUtils.showErrorAlert("Error", "Error", "Year is not valid!");
            }
        });


        /*
        ВЫЗОВЫ ДЛЯ КНОПОК РАЗДЕЛА СПИСКОВ ПАССАЖИРОВ
         */
        onboardPassengerFetchOriginButton.setOnAction(e -> {
            fetchOnboard();
        });
        onboardPassengerAddButton.setOnAction(e -> {
            if(onboardPassengerFlightsList.getSelectionModel().isEmpty() || onboardPassengerList.getSelectionModel().isEmpty())
                return;

            String flight = onboardPassengerFlightsList.getSelectionModel().getSelectedItem();
            String passenger = onboardPassengerList.getSelectionModel().getSelectedItem();
//            System.out.println(flight + " " + passenger);

            addOnboard(flight, passenger);
        });

        onboardPassengerRemoveButton.setOnAction(e -> {
            if(onboardPassengerFlightsList.getSelectionModel().isEmpty() || onboardPassengerList.getSelectionModel().isEmpty())
                return;

            String flight = onboardPassengerFlightsList.getSelectionModel().getSelectedItem();
            String passenger = onboardPassengerList.getSelectionModel().getSelectedItem();
//            System.out.println(flight + " " + passenger);

            deleteOnboard(flight, passenger);
        });

        onboardPassengerShowButton.setOnAction(e -> {
            if(onboardPassengerFlightsList.getSelectionModel().isEmpty())
                return;
            String flight = onboardPassengerFlightsList.getSelectionModel().getSelectedItem();

            showOnboard(flight);
        });
        /*
        ВЫЗОВЫ ДЛЯ КНОПОК РАЗДЕЛА РЕЙСЫ
         */
        flightFetchOriginButton.setOnAction(e -> {
            fetchFlights();
        });
        flightSearchButton.setOnAction(e -> {
            String fn = flightNumberField.getText();
            String fdt = flightDepartureTimeField.getText();
            String fic = flightIsCanceledField.getText();
            String frn = flightRouteNumberField.getText();
            String fatn = flightAircraftTailNumberField.getText();
            clearFlightFields();
            searchFlight(fn, fdt, fic, frn, fatn);
        });
        /*
        ВЫЗОВЫ ДЛЯ КНОПОК РАЗДЕЛА САМОЛЕТОВ
         */
        aircraftFetchOriginButton.setOnAction(e -> {
            fetchAircraft();
        });
        aircraftSearchButton.setOnAction(e -> {
            String atn = aircraftTailNumberField.getText();
            String am = aircraftModelField.getText();
            String amd = aircraftManufactureDateField.getText();
            String al = aircraftLifeTimeField.getText();
            String air = aircraftIsReadyField.getText();
            String acn = aircraftCommanderNumberField.getText();
            clearAircraftFields();
            searchAircraft(atn, am, amd, al, air, acn);
        });

        /*
        ВЫЗОВЫ ДЛЯ КНОПОК РАЗДЕЛА ПАССАЖИРОВ!!!
         */

        passengerFetchOriginButton.setOnAction(e -> {
            fetchPassengers();
        });


        passengerSearchButton.setOnAction(e -> {
            String pp = passengerPassportField.getText();
            String pl = passengerLastnameField.getText();
            String pf = passengerFirstnameField.getText();
            String pa = passengerAddressField.getText();
            String pph = passengerPhoneField.getText();
            clearPassengerFields();
            searchPassenger(pp, pl, pf, pa, pph);
        });

        passengerAddButton.setOnAction(e -> {
            String pp = passengerPassportField.getText();
            String pl = passengerLastnameField.getText();
            String pf = passengerFirstnameField.getText();
            String pa = passengerAddressField.getText();
            String pph = passengerPhoneField.getText();
            clearPassengerFields();
            addPassenger(pp, pl, pf, pa, pph);
        });

        passengerDeleteButton.setOnAction(e -> {
            Passenger p = passengerTable.getSelectionModel().getSelectedItem();
            if (p != null) {
                try {
                    dataBase.statement.execute("DELETE FROM passenger where passport = \"" + p.getPassport() + "\";");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            fetchPassengers();
        });
        passengerTable.setOnMouseClicked(this::showSelectedPassenger);
        passengerEditButton.setOnAction(e -> {
            String pp = passengerPassportField.getText();
            String pl = passengerLastnameField.getText();
            String pf = passengerFirstnameField.getText();
            String pa = passengerAddressField.getText();
            String pph = passengerPhoneField.getText();
            clearPassengerFields();
            editPassenger(pp, pl, pf, pa, pph);
            passengerTable.getSelectionModel().clearSelection();
        });
        /*
        ВЫЗОВЫ ДЛЯ КНОПОК РАЗДЕЛА МАРШРУТОВ!!!
         */
        routeFetchOriginButton.setOnAction(e -> {
            fetchRoutes();
        });

        routeSearchButton.setOnAction(e -> {
            String rn = routeNumberField.getText();
            String rd = routeDepartureField.getText();
            String ra = routeArrivalField.getText();
            String rp = routePriceField.getText();
            String rdur = routeDurationField.getText();
            clearRouteFields();
            //InputMask.isValidRoute(rn, rd, ra, rp, rdur)
            searchRoutes(rn, rd, ra, rp, rdur);
        });
        /*
        ВЫЗОВЫ ДЛЯ КНОПОК РАЗДЕЛА КОММАНДИРОВ
         */
        commanderFetchOriginButton.setOnAction(e -> {
            fetchCommanders();
        });

        commanderSearchButton.setOnAction(e -> {
            String cpn = commanderPersonalNumberField.getText();
            String cl = commanderLastnameField.getText();
            String cf = commanderFirstnameField.getText();
            String ca = commanderAddressField.getText();
            String cph = commanderPhoneField.getText();
            String cfh = commanderFlyingHoursField.getText();
            clearCommanderFields();
            searchCommander(cpn, cl, cf, ca, cph, cfh);
        });

    }

//    public void transferUserData(User u) {
//        user = u;
//        System.out.println(this.user);
////        System.out.println(user.getLogin() + user.getPassword());
//    }
    private User deserializeUserData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))) {
            return (User) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}
