# Project 3 - Twitter Client

## Overview

Twitter client is an app that allows a user to view and post Twitter content using their API by logging in through OAuth

Time Spent: 23 hours

## User Stories

  * Required User Stories
	*  :white_check_mark: User can sign in to Twitter using OAuth login (2 points)
	*  :white_check_mark: User can view the tweets from their home timeline
		*  :white_check_mark: User should be displayed the username, name, and body for each tweet (2 points)
		*  :white_check_mark: User should be displayed the relative timestamp for each tweet "8m", "7h" (1 point)
		*  :white_check_mark: User can view more tweets as they scroll with infinite pagination (1 point)
	*  :white_check_mark: User can compose a new tweet
		*  :white_check_mark: User can click a “Compose” icon in the Action Bar on the top right (1 point)
		*  :white_check_mark: User can then enter a new tweet and post this to twitter (2 points)
		*  :white_check_mark: User is taken back to home timeline with new tweet visible in timeline (1 point)
	* Advanced User Stories
		*  :white_check_mark: Advanced: While composing a tweet, user can see a character counter with characters remaining for tweet out of 140 (1 point)
		*  :white_check_mark: Advanced: Links in tweets are clickable and will launch the web browser (see autolink) (1 point)
		*  :white_check_mark: Advanced: User can refresh tweets timeline by pulling down to refresh (i.e pull-to-refresh) (1 point)
		*  :white_large_square: Advanced: User can open the twitter app offline and see last loaded tweets
			*  :white_large_square: 	Tweets are persisted into sqlite and can be displayed from the local DB (2 points)
		*  :white_check_mark: Advanced: User can tap a tweet to display a "detailed" view of that tweet (2 points)
		*  :white_check_mark: Advanced: User can select "reply" from detail view to respond to a tweet (1 point)
		*  :white_check_mark: Advanced: Improve the user interface and theme the app to feel "twitter branded" (1 to 5 points)
	* Bonus User Stories
		*  :white_check_mark: Bonus: User can see embedded image media within the tweet detail view (1 point)
		*  :white_check_mark: Bonus: User can watch embedded video within the tweet (1 point)
		*  :white_check_mark: Bonus: Compose activity is replaced with a modal overlay (2 points)
		*  :white_check_mark: Bonus: Use Parcelable instead of Serializable using the popular Parceler library. (1 point)
		*  :white_check_mark: Bonus: Apply the popular Butterknife annotation library to reduce view boilerplate. (1 point)
		*  :white_check_mark: Bonus: Leverage the popular GSON library to streamline the parsing of JSON data. (1 point)
		*  :white_check_mark: Bonus: Leverage RecyclerView as a replacement for the ListView and ArrayAdapter for all lists of tweets. (2 points)
		*  :white_check_mark: Bonus: Move the "Compose" action to a FloatingActionButton instead of on the AppBar. (1 point)
		*  :white_check_mark: Bonus: Replace Picasso with Glide for more efficient image rendering. (1 point)

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

![General Functionality](https://github.com/franklinho/twitter-client-android/blob/master/TwitterClientWalkThrough.gif)
![Animated Buttons](https://github.com/franklinho/twitter-client-android/blob/master/TwitterClientWalkThrough2.gif)


## Open-source libraries used

 * [scribe-java](https://github.com/fernandezpablo85/scribe-java) - Simple OAuth library for handling the authentication flow.
 * [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
 * [codepath-oauth](https://github.com/thecodepath/android-oauth-handler) - Custom-built library for managing OAuth authentication and signing of requests
 * [Picasso](https://github.com/square/picasso) - Used for async image loading and caching them in memory and on disk.
 * [ActiveAndroid](https://github.com/pardom/ActiveAndroid) - Simple ORM for persisting a local SQLite database on the Android device
 * [RoundedImageView](https://github.com/vinc3m1/RoundedImageView) - Library that rounds images for profile pictures
 * [Butterknife](http://jakewharton.github.io/butterknife/) - Removes boilerplate code by binding view IDs to objects
 * [Joda Time Android](https://github.com/dlew/joda-time-android) - Date formatting and handling libarary
 * [Parceler](https://github.com/johncarl81/parceler) - Simplifies parceling objects

## License

Copyright 2016 Franklin Ho

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.