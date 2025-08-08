package com.hightower.dns;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeaderTest {

    private static final char TEST_ID = 22;

    @Test
    public void testFlags_QR() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0000)
                .build();
        assertFalse(classUnderTest.isQuestion());
    }

    @Test
    public void testFlags_QR_1() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0xF000)
                .build();
        assertTrue(classUnderTest.isQuestion());
    }

    @Test
    public void testFlags_OpCode_Standard() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0000)
                .build();
        assertTrue(classUnderTest.isQueryType(Header.STANDARD_QUERY));

    }

    @Test
    public void testFlags_OpCode_Inverse() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0F00)
                .build();
        assertTrue(classUnderTest.isQueryType(Header.INVERSE_QUERY));
    }


    @Test
    public void testFlags_OpCode_ServerStatus() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x1000)
                .build();
        assertTrue(classUnderTest.isQueryType(Header.SERVER_STATUS));
    }

    @Test
    public void testFlags_AA() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0400)
                .build();
        assertTrue(classUnderTest.isAuthoritative());
    }

    @Test
    public void testFlags_TC() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0200)
                .build();
        assertTrue(classUnderTest.isTruncation());
    }

    @Test
    public void testFlags_RD() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0100)
                .build();
        assertTrue(classUnderTest.isRecursionDesired());
    }

    @Test
    public void testFlags_RA() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0x0080)
                .build();
        assertTrue(classUnderTest.isRecursionAvailable());
    }

    @Test
    public void testRcode_Success() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)0)
                .build();
        assertEquals(Header.SUCCESS, classUnderTest.getStatus());
    }

    @Test
    public void testRcode_FormatError() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)1)
                .build();
        assertEquals(Header.FORMAT_ERROR, classUnderTest.getStatus());
    }

    @Test
    public void testRcode_ServerFailure() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)2)
                .build();
        assertEquals(Header.SERVER_FAILURE, classUnderTest.getStatus());
    }

    @Test
    public void testRcode_NameError() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)3)
                .build();
        assertEquals(Header.NAME_ERROR, classUnderTest.getStatus());
    }

    @Test
    public void testRcode_NotImplemented() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)4)
                .build();
        assertEquals(Header.NOT_IMPLEMENTED, classUnderTest.getStatus());
    }

    @Test
    public void testRcode_Refused() {
        Header classUnderTest = new Header.Builder(TEST_ID)
                .flags((char)5)
                .build();
        assertEquals(Header.REFUSED, classUnderTest.getStatus());
    }


}
