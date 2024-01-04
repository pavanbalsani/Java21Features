package org.example;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.SequencedMap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class SequencedCollectionTest {
    @Test
    void testSequencedCollectionLinkedHashset() {
        SequencedCollection<String> languages = LinkedHashSet.newLinkedHashSet(10);
        languages.add("English");
        languages.add("Spanish");
        languages.add("French");
        languages.add("Italian");
        languages.addFirst("Portuguese");

        assertThat(languages.getFirst()).isEqualTo("Portuguese");
        assertThat(languages.getLast()).isEqualTo("Italian");

        assertThat(languages)
                .containsExactly("Portuguese", "English", "Spanish", "French", "Italian");

        SequencedCollection<String> reversed = languages.reversed();
        assertThat(reversed)
                .containsExactly("Italian", "French", "Spanish", "English", "Portuguese");
    }

    @Test
    void testSequencedCollectionsMap() {
        SequencedMap<Integer,String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1,"one"); // [(1,"one")]
        System.out.println(linkedHashMap);
        linkedHashMap.putFirst(0,"zero"); // [(0,"zero"), (1,"one")]
        System.out.println(linkedHashMap);
        linkedHashMap.putLast(2,"two"); // [(0,"zero"), (1,"one"), (2,"two")]
        System.out.println(linkedHashMap);
        linkedHashMap.firstEntry(); // (0,"zero")
        System.out.println(linkedHashMap);
        linkedHashMap.lastEntry(); // (2,"two")
        System.out.println(linkedHashMap);
        linkedHashMap.reversed(); // [(2,"two"), (1,"one"), (0,"zero")]
        System.out.println(linkedHashMap);
    }
}