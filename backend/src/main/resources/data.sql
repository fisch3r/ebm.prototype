-- user data
insert into USER (username, password) values ('admin', 'admin');

-- some locations for test beacons
insert into BEACON_LOCATION (street, house_number, zip_code, city, country, lat, lng) values ('Hauptstraße', '1', '69117', 'Heidelberg', 'DE', 49.4098122, 8.6916035);
insert into BEACON_LOCATION (street, house_number, zip_code, city, country, lat, lng) values ('Bergheimerstraße', '1', '69115', 'Heidelberg', 'DE', 49.4089005, 8.6910392);
insert into BEACON_LOCATION (street, house_number, zip_code, city, country, lat, lng) values ('Zeppelinstraße', '1', '69121', 'Heidelberg', 'DE', 49.4210728, 8.683729);

-- some test beacons
insert into BEACON (uuid, type, reference_id, location_id, campaign_id) values ('2f6b2e74-b71a-11e5-9912-ba0be0483c18', 'iBeacon', 'referenz1', 1, 1);
insert into BEACON (uuid, type, reference_id, location_id, campaign_id) values ('2f6b320c-b71a-11e5-9912-ba0be0483c18', 'Eddystone', 'referenz2', 2, 2);
insert into BEACON (uuid, type, reference_id, location_id, campaign_id) values ('2f6b34c8-b71a-11e5-9912-ba0be0483c18', 'iBeacon', 'referenz3', 3, 3);

--some test campaigns
insert into CAMPAIGN (customer, campaign_name, start_date, end_date) values ('Aldi', 'SSV', '2016-01-01', '2016-06-30');
insert into CAMPAIGN (customer, campaign_name, start_date, end_date) values ('Lidl', 'WSV', '2016-10-01', '2016-12-31');
insert into CAMPAIGN (customer, campaign_name, start_date, end_date) values ('Netto', 'GhettoMarkenDiscount', '2016-06-01', '2016-09-30');