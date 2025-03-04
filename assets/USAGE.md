The user wants to manage all his RSS links.
To do that, he must add and delete RSSs. You may think about updating 
(to use PUT or PATCH), but now that it gets interesting! What If he could
add some RSS to favorite!!!! Amazing don't you think?

So, Here it goes, An user enters his rss, than he can add or remove(PUT) it from favorites.

Now, we need something to create a relation between tables, so he needs something to link an RSS.

We could think about posts. So an RSS has some posts, and each post links to an RSS.

This way, we could have a table for users, that maps to a table with RSSs than a last table linking an RSS to posts.
