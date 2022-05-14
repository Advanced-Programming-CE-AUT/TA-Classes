# Coffman rules

having things laid out graphically like so makes things so easy to understand.<br>
But things aren't that easy always :( <br>
It is better to have a formal definition of what deadlock is and when it can occur? <br>
it turns out [Prof. Coffman](https://en.wikipedia.org/wiki/Edward_G._Coffman_Jr.) has 4 rules established for
determining
this situation:

1. Mutual Exclusion: A concurrent process holds exclusive rights to a resource at any one time.
2. Wait for condition: A concurrent process must simultaneously hold a resource and be waiting for an additional
   resource
3. No Preemption: A resource held by a concurrent process can only be released by that process
4. Circular Wait: A concurrent process (P1) must be waiting on a chain of other concurrent processes (P2), which
   are in turn waiting on it (P1)

For a deadlock to occur all above rules must hold simultaneously.

## Solution

Just make sure at least one of coffman rules doesn't hold at any given time!<br>

