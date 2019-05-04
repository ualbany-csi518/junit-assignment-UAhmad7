package sampleQueue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class QueueTest
{
	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;

	@Test
	@Disabled
	@DisplayName("is instantiated with new Queue()")
	void isInstantiatedWithNew() {
		new Queue<>();
	}

	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}

	@Test
	@DisplayName("Verify Queue isEmpty when queue is initialized")
	void isEmptyShouldGiveTrueOnQueueInit() {
		assertTrue(q.isEmpty());
	}

    @Test
    @DisplayName("Verify Queue isEmpty when queue is initialized with maxLength")
    void isEmptyShouldGiveTrueOnQueueInitWithMaxLength()
    {
        q = new Queue<>(5);
        assertTrue(q.isEmpty());
    }

    @Test
    @DisplayName("Verify Item is added when queue isEmpty")
    void isItemAddedWhenQueueIsEmpty()
    {
        q.enqueue("Hello");
        assertFalse(q.isEmpty());
    }

    @Test
    @DisplayName("Verify Item is added when queue is not empty")
    void isItemAddedWhenQueueIsNotEmpty()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        assertEquals(q.size(), 2);
    }

    @Test
    @DisplayName("Verify Item does not get added when queue is at maxLength")
    void isItemNotAddedWhenQueueIsAtMaxLength()
    {
        q = new Queue<>(2);
        q.enqueue("Hello");
        q.enqueue("World");
        q.enqueue("Don't add this");
        assertTrue(q.size() <= 2);
    }

    @Test
    @DisplayName("Verify Dequeue throws an exception when Queue isEmpty")
    void verifyDequeueThrowsExcceptionWhenQueueIsEmpty()
    {
        assertThrows(NoSuchElementException.class, () -> q.dequeue());
    }

    @Test
    @DisplayName("Verify Dequeue removes first Item when Queue is not empty")
    void verifyDequeueRemovesFirstItemWhenQueueIsNotEmpty()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        assertEquals(q.dequeue(), "Hello");
        assertEquals(q.size(), 1);
    }

    @Test
    @DisplayName("Verify peek throws an exception when Queue isEmpty")
    void verifyPeekThrowsExcceptionWhenQueueIsEmpty()
    {
        assertThrows(NoSuchElementException.class, () -> q.peek());
    }

    @Test
    @DisplayName("Verify peek returns first Item when Queue is not empty")
    void verifyPeekReturnsFirstItemWhenQueueIsNotEmpty()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        assertEquals(q.peek(), "Hello");
    }

    @Test
    @DisplayName("Verify length returns the correct Item count")
    void verifyLengthReturnsCorrectItemCount()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        q.dequeue();
        q.enqueue("ABC");
        assertEquals(q.length(), 2);
    }

    @Test
    @DisplayName("Verify isEmpty is true when no Item in Queue")
    void verifyIsEmptyTrueWhenQueueIsEmpty()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        q.dequeue();
        q.dequeue();
        assertTrue(q.isEmpty());
    }

    @Test
    @DisplayName("Verify isEmpty is false when Queue has at least one Item")
    void verifyIsEmptyFalseWhenQueueHasItem()
    {
        q.enqueue("Hello");
        assertFalse(q.isEmpty());
    }

    @Test
    @DisplayName("Verify removeAll removes all Items from Queue")
    void verifyRemoveAllRemovesAllItemsFromQueue()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        q.enqueue("ABC");
        q.removeAll();
        assertTrue(q.isEmpty());
    }

	//Example of Wrong Test! 
	@Test
	@Disabled
	@DisplayName("Verify Queue isEmpty returns false when queue is not empty")
	void isEmptyShouldGiveFalseWhenQueueIsNotEmpty() {
		this.q.enqueue(SOME_ITEM);
		assertFalse(q.isEmpty());
	}
}
