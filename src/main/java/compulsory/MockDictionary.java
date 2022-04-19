package compulsory;

import com.github.javafaker.Faker;

import java.util.ArrayList;

public class MockDictionary implements Dictionary {

    public boolean isWord(String str) {
        return true;
    }

    @Override
    public void generateWords(int howMany) {
        Faker faker = new Faker();
        
    }
}
