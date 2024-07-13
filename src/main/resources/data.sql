--DELETE FROM trip;
--DELETE FROM app_user;
--DELETE FROM spot;
--
--INSERT INTO spot (spot_id, location_name, latitude, longitude, tide_station_id)
--VALUES
--(1, 'Castle Haven Bay', -4.1925652, 54.8083162, '0265'),
--(2, 'Kirkandrews Bay', -4.1885101, 54.8072633, '0308'),
--(3, 'Unknown', -4.259116, 54.837657, '0309'),
--(4, 'Ross Bay', -4.0919856, 54.7785707, '0310'),
--(5, 'Ringdoo Sands', -4.8105347, 54.8492277, '0310A'),
--(6, 'Roker Beach', -1.3671113, 54.9285419, '0310B'),
--(7, 'Whitburn Sands', -1.3659152, 54.9314947, '0311'),
--(8, 'Tynemouth Longsands', -1.4232026, 55.0197293, '0311A'),
--(9, 'Bamburgh Beach', -1.7195213, 55.6062097, '0312'),
--(10, 'Seaburn Beach', -1.3767934, 54.9249723, '0313'),
--(11, 'South Shields Beach', -1.4173152, 54.9879942, '0314'),
--(12, 'Whitley Bay', -1.4475943, 55.0502631, '0314A'),
--(13, 'Blyth Beach', -1.5075686, 55.1266329, '0316'),
--(14, 'Druridge Bay', -1.5493858, 55.235633, '0317'),
--(15, 'Newbiggin-by-the-Sea', -1.5117774, 55.186135, '0318'),
--(16, 'Cresswell Beach', -1.527779, 55.247395, '0318A'),
--(17, 'Alnmouth Beach', -1.6155665, 55.3840332, '0320'),
--(18, 'Warkworth Beach', -1.6142972, 55.3576397, '0321'),
--(19, 'Amble Links', -1.583502, 55.333837, '0321A'),
--(20, 'Boulmer Haven', -1.617201, 55.405376, '0323'),
--(21, 'Beadnell Bay', -1.635396, 55.483702, '0330'),
--(22, 'Seahouses Beach', -1.657981, 55.576992, '0332'),
--(23, 'Holy Island', -1.790219, 55.685302, '0333'),
--(24, 'Embleton Bay', -1.635683, 55.486521, '0334'),
--(25, 'Low Newton by the Sea', -1.631545, 55.484119, '0336')
--ON CONFLICT (spot_id) DO NOTHING;
--
--INSERT INTO app_user (id, user_name, location, profile_text, skill_level, email)
--VALUES
--(1, 'Ste', 'UK', 'Not much of a surfer', 0, 'ste@gmail.com'),
--(2, 'Tom', 'UK', 'Not much of a surfer', 0, 'tom@gmail.com'),
--(3, 'Francis', 'UK', 'Not much of a surfer', 0, 'francis@gmail.com'),
--(4, 'Jonah', 'UK', 'Quite the surfer', 2, 'jonah@gmail.com')
--ON CONFLICT (id) DO NOTHING;
--
--INSERT INTO trip (trip_id, info_rating, surf_rating, spot_id, user_id, gusts, wave_direction, wave_height, wave_period, wind_direction, wind_speed, low_tide_height, high_tide_height, high_tide_date, low_tide_date)
--VALUES
--(1, 3, 4, 3, 2, 1.8,  'NW', 1.7, 2.1, 'NE', 2.8, 1.9, 2.9, '2024-07-11T03:21:00', '2024-07-11T09:21:00'),
--(2, 5, 2, 1, 3, 2.5,  'SE', 2.2, 2.5, 'S', 3.0, 2.1, 2.8, '2024-07-11T05:21:00', '2024-07-11T11:21:00'),
--(3, 2, 5, 4, 1, 1.5,  'E', 1.9, 2.3, 'NE', 2.6, 2.0, 2.7, '2024-07-11T01:21:00', '2024-07-11T07:21:00'),
--(4, 4, 3, 2, 4, 1.7,  'SW', 2.0, 2.4, 'W', 2.9, 1.8, 2.6, '2024-07-11T02:21:00', '2024-07-11T08:21:00'),
--(5, 1, 1, 5, 2, 2.0,  'NW', 2.1, 2.2, 'N', 2.5, 2.2, 2.5, '2024-07-11T04:21:00', '2024-07-11T10:21:00'),
--(6, 4, 5, 3, 1, 1.6,  'W', 2.3, 2.6, 'SW', 2.7, 1.7, 2.4, '2024-07-11T03:21:00', '2024-07-11T09:21:00'),
--(7, 3, 2, 1, 4, 2.3,  'NE', 2.4, 2.7, 'E', 2.5, 2.3, 2.8, '2024-07-11T05:21:00', '2024-07-11T11:21:00'),
--(8, 5, 4, 5, 3, 1.9,  'S', 2.5, 2.8, 'SE', 2.8, 1.6, 2.3, '2024-07-11T01:21:00', '2024-07-11T07:21:00'),
--(9, 2, 3, 2, 1, 2.2,  'NW', 2.6, 2.9, 'N', 2.9, 2.1, 2.6, '2024-07-11T02:21:00', '2024-07-11T08:21:00'),
--(10, 3, 1, 4, 2, 1.8,  'SW', 2.7, 2.2, 'W', 3.0, 1.9, 2.7, '2024-07-11T04:21:00', '2024-07-11T10:21:00'),
--(11, 5, 3, 1, 3, 2.0,  'SE', 2.8, 2.5, 'S', 2.6, 2.0, 2.9, '2024-07-11T03:21:00', '2024-07-11T09:21:00'),
--(12, 1, 4, 5, 4, 1.5,  'E', 1.7, 2.3, 'NE', 2.8, 1.8, 2.5, '2024-07-11T05:21:00', '2024-07-11T11:21:00'),
--(13, 4, 2, 3, 2, 1.7,  'W', 2.0, 2.4, 'SW', 2.9, 1.7, 2.4, '2024-07-11T01:21:00', '2024-07-11T07:21:00'),
--(14, 2, 5, 2, 1, 2.0,  'NW', 2.1, 2.2, 'N', 2.5, 2.2, 2.5, '2024-07-11T02:21:00', '2024-07-11T08:21:00'),
--(15, 3, 3, 4, 3, 1.6,  'NE', 2.3, 2.6, 'E', 2.7, 1.8, 2.6, '2024-07-11T04:21:00', '2024-07-11T10:21:00'),
--(16, 5, 2, 1, 2, 2.3,  'S', 2.4, 2.7, 'SE', 2.5, 2.3, 2.8, '2024-07-11T03:21:00', '2024-07-11T09:21:00'),
--(17, 2, 4, 5, 1, 1.9,  'NW', 2.5, 2.8, 'N', 2.8, 1.6, 2.3, '2024-07-11T05:21:00', '2024-07-11T11:21:00'),
--(18, 4, 3, 3, 4, 2.2,  'SW', 2.6, 2.9, 'W', 2.9, 2.1, 2.6, '2024-07-11T01:21:00', '2024-07-11T07:21:00'),
--(19, 1, 1, 2, 3, 1.8,  'SE', 2.7, 2.2, 'S', 3.0, 1.9, 2.7, '2024-07-11T02:21:00', '2024-07-11T08:21:00'),
--(20, 4, 5, 4, 2, 2.0,  'E', 2.8, 2.5, 'NE', 2.6, 2.0, 2.9, '2024-07-11T04:21:00', '2024-07-11T10:21:00'),
--(21, 3, 2, 1, 1, 1.5,  'W', 1.7, 2.3, 'SW', 2.8, 1.8, 2.5, '2024-07-11T03:21:00', '2024-07-11T09:21:00'),
--(22, 5, 4, 5, 4, 1.6,  'NW', 2.0, 2.4, 'N', 2.9, 1.7, 2.4, '2024-07-11T05:21:00', '2024-07-11T11:21:00'),
--(23, 2, 3, 3, 3, 2.0,  'NE', 2.1, 2.2, 'E', 2.5, 2.2, 2.5, '2024-07-11T01:21:00', '2024-07-11T07:21:00'),
--(24, 3, 1, 2, 2, 1.7,  'NW', 2.3, 2.6, 'N', 2.7, 1.8, 2.6, '2024-07-11T02:21:00', '2024-07-11T08:21:00'),
--(25, 1, 4, 4, 1, 2.3,  'SE', 2.4, 2.7, 'S', 2.5, 2.3, 2.8, '2024-07-11T04:21:00', '2024-07-11T10:21:00')
--ON CONFLICT (trip_id) DO NOTHING;
