-- user data
insert into USER (username, password) values ('admin', 'admin');

-- some locations for test beacons
insert into BEACON_LOCATION (street, house_number, zip_code, city, country, lat, lng) values ('Hauptstraße', '1', '69117', 'Heidelberg', 'DE', 49.4098122, 8.6916035);
insert into BEACON_LOCATION (street, house_number, zip_code, city, country, lat, lng) values ('Bergheimerstraße', '1', '69115', 'Heidelberg', 'DE', 49.4089005, 8.6910392);
insert into BEACON_LOCATION (street, house_number, zip_code, city, country, lat, lng) values ('Zeppelinstraße', '1', '69121', 'Heidelberg', 'DE', 49.4210728, 8.683729);

-- some test beacons
insert into BEACON (uuid, type, location_id) values ('2f6b2e74-b71a-11e5-9912-ba0be0483c18', 'iBeacon', 1);
insert into BEACON (uuid, type, location_id) values ('2f6b320c-b71a-11e5-9912-ba0be0483c18', 'Eddystone', 2);
insert into BEACON (uuid, type, location_id) values ('2f6b34c8-b71a-11e5-9912-ba0be0483c18', 'iBeacon', 3);