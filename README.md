# hospital
1. Clone project to your local machine by using this link https://github.com/WolfVV/hospital.git
2. Open "hospital" project
3. Find the "testng.xml" file
4. Click the "testng.xml" file by right button of your mouse 
5. Click the "Run...\testng.xml" option
6. Tests is run

Additional info:
If test should be run on another OS: 
1. Declare variables for another OS in the "TestBasePattern" clase(add path from WebDriver folder. It contains Windows/Linux/MAC folders with Chrome and FireFox browsers) 
2. Change them in System.setProperty(MOZILLA_DRIVER_PROPERTY, MOZILLA_DRIVER_LOCATION) methods for both browsers
