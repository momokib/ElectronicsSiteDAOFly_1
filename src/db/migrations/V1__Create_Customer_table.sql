CREATE TABLE Customer(
    Customer_ID int NOT NULL PRIMARY KEY,
    Customer_First_Name VARCHAR(20) NOT NULL,
    Customer_Last_Name VARCHAR(20) NOT NULL,
    Customer_Street_Address VARCHAR(40) NOT NULL,
    Customer_City VARCHAR(20) NOT NULL,
    Customer_Zip_Code int NOT NULL,
    Customer_State VARCHAR(20) NOT NULL,
    Customer_Phone_Number VARCHAR(20) NOT NULL
);