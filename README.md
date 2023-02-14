# Movie Wizard Suite

## TODO:

# 1. __Project setup__

## 1.1. Choose API source / Get API key

## 1.2 Setup variables

## ~~1.2.1 Colors~~
- black: #222
- white: #fff
- gray: #9B9B9B
- lightGray: #F9F9F9
- green: #2AA952
- mainRed: #DB3022
- accentRed: #F01F0E

## ~~1.2.2 Strings~~

## ~~1.2.3 Images~~
- Splashscreen
- Nav icon movies
- Nav icon tvshows
- (Nav) icon favorites filled
- Icon favorites empty
- Loader
- Icon filters
- Icon sort
- Icon search
- Icon rating star empty
- Icon rating star filled
- Icon chevron (left)

1.2.4 ~~Fonts~~:
- Roboto

2. ### ~~__Screens__~~
- Splash screen
- Movies
- TV Shows
- Favorites

# 2. Planned Tasks:
- Create app layout and design
	- Create navigation
		- ~~Create bottom navigation~~ 
	- Create header

- Get data for N entities objects (prefeably while splash screen is loading)
	- Call api
	- ~~Create splashcreen~~

- Display a scrollble list of entity objects
	- Use a list view (upgrade to recycler view)
	- Create movie preview item layout and design
	- Create filter

- Create a dedicated entity page
	- Create layout and design

- Create favorites page
	- Create thumbnail view
	- Create side scrolling tracks

- Various additional tasks
	- List page:
		- Search
		- Filters
		- Sorting
	- ~~Use env file for the API key~~

# 3. Additinal info


## Entity object data:
- (string) title
- (string/blob?) description
- (string)image url
- (strng) release date
- (integer) rating
- (string) genre
- (boolean) is favorite
- (string[]) trailer urls
- (boolean) 
