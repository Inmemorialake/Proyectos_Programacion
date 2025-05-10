# This script is designed to visit a website multiple times using different proxies.
# It uses the requests library to make HTTP requests and random to select a proxy from a list.
# It also includes a sleep function to wait for a random amount of time between requests.

# Importing the necessary libraries
import requests
import random
import time

# The list of proxies that you can use
# You can add your own proxies here
proxies = [
    "181.119.84.212:8080",
    "200.6.178.61:8080",
    "45.167.126.37:999",
    "200.110.173.17:999",
    "200.6.178.20:9992",
    "181.78.84.79:999",
    "38.191.146.7:999",
    "200.6.178.21:9992",
    "190.6.162.3:8080",
    "45.167.126.105:999",
    "181.129.252.123:999",
    "38.199.30.195:999",
    "200.6.178.21:999",
    "201.185.42.139:11201",
    "181.204.183.251:999",
    "200.6.176.58:9991",
    "200.6.176.62:9992",
    "200.116.198.222:9812",
    "181.119.86.188:999",
    "181.119.86.186:999",
    "200.6.176.58:9992",
    "38.199.30.173:999",
    "38.191.209.202:999",
    "181.119.84.87:999",
    "204.199.81.94:999",
    "200.6.179.53:999",
    "181.129.250.46:999",
    "181.52.238.165:54694",
    "45.167.126.237:999",
    "190.71.82.182:999"
]

# El emprendimiento del novio / El onlyfans XD
# The info that the server will see
# You can change the User-Agent to simulate different browsers
# You can also add more headers if needed
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64)"
}

# URL of the site you want to visit
# You can change this to the site you want to visit
url = "https://www.google.com"

# Number of times you want to visit the site
# You can change this to the number of times you want to visit th site
times = 100

# Main loop to visit the site
# This loop will run 'times' times
# Each time it will select a random proxy from the list and make a request to the site
# It will also print the status code of the response
for i in range(times):
    proxy = random.choice(proxies)
    proxy_dict = {
        "http": proxy,
        "https": proxy
    }
    try:
        response = requests.get(url, headers=headers, proxies=proxy_dict, timeout=10)
        print(f"[{i+1}] Visitó con proxy {proxy} - Código: {response.status_code}")
    except Exception as e:
        print(f"[{i+1}] Falló con proxy {proxy}: {e}")
    time.sleep(random.uniform(2, 5))  # Wait for a random time between 2 and 5 seconds
