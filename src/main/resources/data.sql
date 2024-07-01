INSERT INTO spot
(spot_id, location_name, latitude, longitude, tide_station_id)
VALUES
(1, 'Castle Haven Bay', -4.1925652, 54.8083162, 'ABC123'),
(2, 'Kirkandrews Bay', -4.1885101, 54.8072633, 'ABC123'),
(3, 'Unknown', -4.259116, 54.837657, 'ABC456'),
(4, 'Ross Bay', -4.0919856, 54.7785707, 'ABC456'),
(5, 'Ringdoo Sands', -4.8105347, 54.8492277, 'ABC789');


INSERT INTO app_user
(id, user_name, location, profile_text, skill_level)
VALUES
(1, 'Ste', 'UK', 'Not much of a surfer', 0),
(2, 'Tom', 'UK', 'Not much of a surfer', 0),
(3, 'Francis', 'UK', 'Not much of a surfer', 0),
(4, 'Jonah', 'UK', 'Quite the surfer', 2);

INSERT INTO trip
(trip_id, info_rating, surf_rating, spot_id, user_id)
VALUES
(1, 2, 3, 3, 1),
(2, 4, 5, 1, 2),
(3, 1, 2, 4, 3),
(4, 3, 4, 2, 1),
(5, 5, 1, 5, 4),
(6, 2, 2, 3, 2),
(7, 4, 3, 1, 3),
(8, 3, 1, 5, 4),
(9, 1, 5, 2, 1),
(10, 5, 4, 4, 3),
(11, 4, 2, 1, 4),
(12, 2, 5, 3, 2),
(13, 3, 3, 2, 1),
(14, 1, 4, 5, 4),
(15, 5, 2, 4, 2),
(16, 3, 5, 1, 3),
(17, 4, 1, 3, 1),
(18, 2, 4, 2, 4),
(19, 1, 3, 5, 2),
(20, 5, 5, 4, 1),
(21, 4, 4, 3, 3),
(22, 2, 1, 2, 4),
(23, 3, 2, 1, 1),
(24, 1, 1, 5, 2),
(25, 5, 3, 4, 3);