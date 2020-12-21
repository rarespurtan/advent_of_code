import sys
import requests

YEAR=2020
day = sys.argv[1]

uri = 'http://adventofcode.com/{year}/day/{day}/input'.format(year=YEAR, day=day)
response = requests.get(uri, cookies={'session': requests.Session()}, headers={'User-Agent': USER_AGENT})
print(response)
