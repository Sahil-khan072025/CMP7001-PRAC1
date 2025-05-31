@echo off
title EDD Technologies System - CSV Initializer

echo Creating 'data' folder and initializing CSV files with headers...

set DATA_DIR=data

if not exist %DATA_DIR% mkdir %DATA_DIR%

rem CUSTOMER CSV
if not exist %DATA_DIR%\customers.csv (
    echo customerId,name,email,phoneNumber,isRegistered>%DATA_DIR%\customers.csv
)

rem TECHNICIAN CSV
if not exist %DATA_DIR%\technicians.csv (
    echo technicianId,name,email,phoneNumber,specialization>%DATA_DIR%\technicians.csv
)

rem ADMIN CSV
if not exist %DATA_DIR%\admins.csv (
    echo adminId,name,email,phoneNumber>%DATA_DIR%\admins.csv
)

rem EQUIPMENT CSV
if not exist %DATA_DIR%\equipment.csv (
    echo equipmentId,customerId,name,type,issueDescription>%DATA_DIR%\equipment.csv
)

rem JOBS CSV
if not exist %DATA_DIR%\jobs.csv (
    echo jobId,equipmentId,technicianId,status,totalCost>%DATA_DIR%\jobs.csv
)

rem SUPPLIERS CSV
if not exist %DATA_DIR%\suppliers.csv (
    echo supplierId,name,location,email,phone>%DATA_DIR%\suppliers.csv
)

rem NOTIFICATIONS CSV
if not exist %DATA_DIR%\notifications.csv (
    echo notificationId,recipientId,message,timestamp,isRead>%DATA_DIR%\notifications.csv
)

echo.
echo CSV initialization complete.
pause
