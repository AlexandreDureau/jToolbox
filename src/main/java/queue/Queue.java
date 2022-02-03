package queue;

import java.util.ArrayList;
import java.util.List;


import static time.Constants.MILISECOND;

public class Queue <type>
{
	public static final boolean BUFFER_A = false;
	public static final boolean BUFFER_B = true;
	public static final int     DFLT_UPDATE_PERIOD = (10 * MILISECOND);


	protected List<type> bufferA;
	protected List<type> bufferB;
	protected List<type> queue;
	protected int updatePeriod_ms;
	protected boolean usedBuffer;
	protected volatile boolean isLocked;
	protected boolean isStarted;
	protected Thread processingLoop;
	protected QueueListener listener;


	public Queue(QueueListener listener)
	{
		this.init(listener);
	}

	public void start()
	{
		if(!isStarted)
		{
			this.buildProcess();
			this.startProcess();
		}
	}
	

	public void stop()
	{
		isStarted = false;
	}


	public void unlock()
	{
		this.lock(false);
	}

	public void lock()
	{
		this.lock(true);
	}
	

	public void lock(boolean lock)
	{
		this.isLocked = lock;
	}
	

	public int getUpdatePeriod()
	{
		return updatePeriod_ms;
	}


	public void setUpdatePeriod(int period)
	{
		if(period > 0)
		{
			updatePeriod_ms = period;
		}
	}
	

	public void push(type entry)
	{
		if(BUFFER_A == usedBuffer)
		{
			bufferA.add(entry);
		}
		else
		{
			bufferB.add(entry);
		}
	}
	

	public type pop()
	{
		type entry = null;
		
		if(!queue.isEmpty())
		{
			entry = queue.get(0);
			queue.remove(0);
		}

		return entry;
	}
	

	public void clear()
	{
		isLocked = true;
		queue.clear();
		isLocked = false;
	}
	
	
	public void clearBuffers()
	{
		isLocked = true;
		bufferA.clear();
		bufferB.clear();
		isLocked = false;
	}

	
	public void clearAll()
	{
		isLocked = true;
		queue.clear();
		bufferA.clear();
		bufferB.clear();
		isLocked = false;
	}
	
	
	public List<type> getBufferA()
	{
		return bufferA;
	}


	public List<type> getBufferB()
	{
		return bufferB;
	}


	public List<type> getQueue()
	{
		return queue;
	}
	
	
	public type get(int index)
	{
		return queue.get(index);
	}
	
	
	public int indexOf(type entry)
	{
		return	queue.indexOf(entry);
	}


	public void remove(type entry)
	{
		queue.remove(entry);
	}


	public void remove(int index)
	{
		queue.remove(index);
	}


	public void removeAll(List<type> collection_list)
	{
		queue.removeAll(collection_list);
		
	}


	public boolean contains(type entry)
	{
		return queue.contains(entry);
	}


	public boolean containsAll(List<type> collection_list)
	{
		return queue.containsAll(collection_list);
	}

	
	public boolean isEmpty()
	{
		return queue.isEmpty();
	}
	
	
	public int size()
	{
		return queue.size();
	}
	


	private void initProcess()
	{
		isStarted = false;
		processingLoop = null;
	}
	

	private void buildProcess()
	{
		processingLoop = new Thread(new Runnable()
		{
			@Override public synchronized void run() 
			{		
				try
				{
					while(isStarted)
					{
						if(!isLocked){
							update();

							if ((!queue.isEmpty()) && (null != listener)) {

								listener.onQueueUpdated();
							}
						}

						Thread.sleep(updatePeriod_ms);
					}
				}
								
				catch(Exception except)
				{
					except.printStackTrace();
				}
			}
		});	
	}
	

	private void startProcess()
	{
		isStarted = true;
		processingLoop.start();
	}
	

	private void toggleBuffer()
	{
		usedBuffer = (BUFFER_A == usedBuffer)? BUFFER_B : BUFFER_A;
	}


	private void update()
	{
		// Buffer A
		if(BUFFER_A == usedBuffer)
		{
			if(!bufferA.isEmpty())
			{
				this.toggleBuffer();
				queue.addAll(bufferA);
				bufferA.clear();
			}
		}
		
		// Buffer B
		else
		{
			if(!bufferB.isEmpty())
			{
				this.toggleBuffer();
				queue.addAll(bufferB);
				bufferB.clear();
			}
		}
	}

	private void init(QueueListener listener)
	{
		isLocked = false;
		this.listener = listener;
		usedBuffer = BUFFER_A;
		bufferA = new ArrayList<type>();
		bufferB = new ArrayList<type>();
		queue = new ArrayList<type>();
		updatePeriod_ms = DFLT_UPDATE_PERIOD;
		this.initProcess();
	}
}
