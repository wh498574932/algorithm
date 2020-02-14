package com.wh498574932.algorithm.lc156;

import com.wh498574932.algorithm.lc297.SerializeAndDeserializeBinaryTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeUpsideDownTest {
    private static final String ORIGINAL = "1,2,4,#,#,5,#,#,3,#,#";
    private static final String EXPECTED = "4,5,#,#,2,3,#,#,1,#,#";
    private final SerializeAndDeserializeBinaryTree serializer = new SerializeAndDeserializeBinaryTree();

    @Test
    public void test() {
        Assertions.assertEquals(
            EXPECTED,
            serializer.serialize(
                new BinaryTreeUpsideDown()
                    .upsideDownBinaryTree(
                        serializer.deserialize( ORIGINAL )
                    )
            )
        );
    }
}
