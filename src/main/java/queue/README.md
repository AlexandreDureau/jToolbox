# Queue
Queue handle a queue of <T>
The queue is feeded synchronously in a thread by a double buffer mechanism : it allows to
push/pop <T> data at the same time without conflict

                                                  +--- Thread ---+    +--- QueueListener ---+
                   + ----> BufferA  ------+       |              |    |                     |
    push() ------- ?                      +-------+--> update()  |    |                     |
                   +-----> BufferB  ------+       |       +------+----+--> onQueueUpdated() |
                                                  +--------------+    |                     |
                                                                      +---------------------+