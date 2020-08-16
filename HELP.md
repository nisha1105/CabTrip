# Getting Started


# Start app: 
java -jar target/CabTrip-0.0.1-SNAPSHOT.jar

### Below are the API URLS:
output will be printed on command line and also a file named out.json

# 1. To clear cache :       
 curl -v http://localhost:8080/cabTrip/clearCache

# 2. To get all trips for given date per cab:
curl -o out.json http://localhost:8080/cabTrip/noOfTripsofCab?medallion=<medallion No>&date=<date in YYYY-MM-DD>
For example:
curl -o out.json http://localhost:8080/cabTrip/noOfTripsofCab?medallion=D7D598CD99978BD012A87A76A7C891B7&date=2013-12-01

# 3. To get all trips for a particular cab:
curl -o out.json http://localhost:8080/cabTrip/noOfTrips?medallion=<medallion>
For example:
curl -o out.json http://localhost:8080/cabTrip/noOfTrips?medallion=D7D598CD99978BD012A87A76A7C891B7

# ByPass cache:

# 4. To get all trips for given date per cab:
curl -o out.json http://localhost:8080/cabTrip/noOfTripsofCab?medallion=<medallion No>&date=<date in YYYY-MM-DD>&noCache=<boolean>
For example:
curl -o out.json http://localhost:8080/cabTrip/noOfTripsofCab?medallion=D7D598CD99978BD012A87A76A7C891B7&date=2013-12-01&noCache=true

# 5. To get all trips for a particular cab:
curl -o out.json http://localhost:8080/cabTrip/noOfTrips?medallion=<medallion>&noCache=<boolean>
For example:
curl -o out.json http://localhost:8080/cabTrip/noOfTrips?medallion=D7D598CD99978BD012A87A76A7C891B7&noCache=true
