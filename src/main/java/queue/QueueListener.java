package queue;


public interface QueueInterface<type>
{
	public void onQueueUpdated(Queue<type> queue);
}
