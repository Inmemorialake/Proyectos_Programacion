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
    ""
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
