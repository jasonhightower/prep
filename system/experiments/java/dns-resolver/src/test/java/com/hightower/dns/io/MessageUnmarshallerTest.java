package com.hightower.dns.io;

import com.hightower.dns.Answer;
import com.hightower.dns.Header;
import com.hightower.dns.Message;
import com.hightower.dns.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HexFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MessageUnmarshallerTest {

    private MessageUnmarshaller classUnderTest;

    @BeforeEach
    public void setUp() {
        this.classUnderTest = new MessageUnmarshaller();
    }

    @Test
    public void testReadHeader_Id() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        Header header = message.header();
        assertEquals(22, header.id());
    }

    @Test
    public void testReadHeader_RecursionDesired() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        Header header = message.header();
        assertTrue(header.isRecursionDesired());
    }

    @Test
    public void testReadHeader_QuestionCount() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        Header header = message.header();
        assertEquals(1, header.questionCount());
    }

    @Test
    public void testReadHeader_AnswerCount() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        Header header = message.header();
        assertEquals(0, header.answerCount());
    }

    @Test
    public void testReadHeader_NSCount() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        Header header = message.header();
        assertEquals(0, header.nsCount());
    }

    @Test
    public void testReadHeader_ARCount() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        Header header = message.header();
        assertEquals(0, header.arCount());
    }

    @Test
    public void testRead_Questions() throws IOException {
        String input = "00160100000100000000000003646e7306676f6f676c6503636f6d0000010001";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        assertNotNull(message.header());
        List<Question> questions = message.questions();
        assertEquals(1, questions.size());

        Question question = questions.get(0);
        assertEquals("dns.google.com", question.name());
        assertEquals(Message.CLASS_INTERNET, question.queryClass());
    }

    @Test
    public void testRead_Answers() throws IOException {
        String input = "00168080000100020000000003646e7306676f6f676c6503636f6d0000010001c00c0001000100000214000408080808c00c0001000100000214000408080404";
        byte[] bytes = HexFormat.of().parseHex(input);

        Message message = this.classUnderTest.unmarshal(bytes);
        assertNotNull(message.header());
        List<Question> questions = message.questions();
        assertEquals(1, questions.size());

        Question question = questions.get(0);
        assertEquals("dns.google.com", question.name());
        assertEquals(Message.CLASS_INTERNET, question.queryClass());

        List<Answer> answers = message.answers();
        assertEquals(2, answers.size());
        assertEquals("dns.google.com", answers.get(0).name());
        assertEquals("8.8.8.8", answers.get(0).data());
        assertEquals("dns.google.com", answers.get(1).name());
        assertEquals("8.8.4.4", answers.get(1).data());
    }

}
