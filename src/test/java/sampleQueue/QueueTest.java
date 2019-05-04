package sampleQueue;

import org.junit.jupiter.api.*;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


class QueueTest
{
	/**
	 * Tests for Queue.
	 */

	private static final String SOME_ITEM = "some-content";
	private Queue<String> q;

	@Nested
    @DisplayName("Constructors test")
    class Constructors
    {
        @Test
        @DisplayName("is instantiated with new Queue()")
        void isInstantiatedWithNew() {
            new Queue<>();
        }

        @Test
        @DisplayName("Verify Queue isEmpty returns true when queue is initialized")
        void isEmptyShouldGiveTrueOnQueueInit() {
            assertTrue(q.isEmpty());
        }

        @Test
        @DisplayName("is instantiated with new Queue(maxLength)")
        void isInstantiatedWithNewWithMaxLength() {
            new Queue<>(5);
        }

        @Test
        @DisplayName("Verify Queue isEmpty returns true queue is initialized with maxLength")
        void isEmptyShouldGiveTrueOnQueueInitWithMaxLength()
        {
            q = new Queue<>(5);
            assertTrue(q.isEmpty());
        }
    }

	@BeforeEach
	void init() {
		this.q = new Queue<String>();
	}

    @Nested
    @DisplayName("IsEmpty Test")
    class IsEmpty
    {
        @Test
        @DisplayName("Verify isEmpty returns true when no item in queue")
        void verifyIsEmptyTrueWhenQueueIsEmpty()
        {
            q.enqueue("Hello");
            q.dequeue();
            assertTrue(q.isEmpty());
        }

        @Test
        @DisplayName("Verify isEmpty returns false when queue has at least one item")
        void verifyIsEmptyReturnsFalseWhenQueueHasItem()
        {
            q.enqueue("Hello");
            assertFalse(q.isEmpty());
        }
    }

    @Test
    @DisplayName("Verify length returns the correct item count")
    void verifyLengthReturnsCorrectItemCount()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        q.dequeue();
        q.enqueue("ABC");
        assertEquals(q.length(), 2);
    }

    @Nested
    @DisplayName("Peek test")
    class Peek
    {
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
    }

    @Nested
    @DisplayName("Enqueue Test")
    class Enqueue
    {
        @Test
        @DisplayName("Verify item is added when queue is empty")
        void verifyItemAddedWhenQueueIsEmpty()
        {
            q.enqueue("Hello");
            assertEquals(q.peek(), "Hello");
        }

        @Test
        @DisplayName("Verify item is added when queue is not empty")
        void verifyItemAddedWhenQueueIsNotEmpty()
        {
            q.enqueue("Hello");
            q.enqueue("World");
            assertEquals(q.peek(), "Hello");
        }

        @Test
        @DisplayName("Verify item is not added when queue is at max length")
        void verifyItemNotAddedWhenQueueIsAtMaxLength()
        {
            q = new Queue<>(2);
            q.enqueue("Hello");
            q.enqueue("World");
            q.enqueue("Don't add this");
            assertTrue(q.size() <= 2);
        }
    }

    @Nested
    @DisplayName("Dequeue Test")
    class Dequeue
    {
        @Test
        @DisplayName("Verify dequeue throws an exception when queue is empty")
        void verifyDequeueThrowsExcceptionWhenQueueIsEmpty()
        {
            assertThrows(NoSuchElementException.class, () -> q.dequeue());
        }

        @Test
        @DisplayName("Verify dequeue removes first item when queue is not empty")
        void verifyDequeueRemovesFirstItemWhenQueueIsNotEmpty()
        {
            q.enqueue("Hello");
            q.enqueue("World");
            assertEquals(q.dequeue(), "Hello");
            assertEquals(q.size(), 1);
        }
    }

    @Test
    @DisplayName("Verify removeAll makes the queue empty")
    void verifyRemoveAllMakesQueueEmpty()
    {
        q.enqueue("Hello");
        q.enqueue("World");
        q.enqueue("ABC");
        q.removeAll();
        assertTrue(q.isEmpty());
    }
}
