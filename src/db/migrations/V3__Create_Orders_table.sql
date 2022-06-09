CREATE TABLE Orders (
    Order_ID int NOT NULL PRIMARY KEY,
    Order_Quantity int NOT NULL,
    Order_Date_TIME TIMESTAMP NOT NULL,
    Customer_ID int NOT NULL,
    Item_ID int NOT NULL,
    FOREIGN KEY (Customer_ID) REFERENCES Customer(Customer_ID),
    FOREIGN KEY (Item_ID) REFERENCES Item(Item_ID)
);