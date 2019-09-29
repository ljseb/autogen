package com.au.autogen.service;

import com.au.autogen.model.BalanceTestResult;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public BalanceTestResult validateBrackets(String input) throws Exception {

        BalanceTestResult result = new BalanceTestResult();
        result.setInput(input);
        // check if the chars match until the middle of the string
        char[] list = input.toCharArray();
        boolean flag = true;
        for (int i = 0; i < list.length / 2; i++) {
            if (list[i] == '(') {
                flag = list[list.length - 1 - i] == ')' ? true : false;
            } else if (list[i] == '[') {
                flag = list[list.length - 1 - i] == ']' ? true : false;
            } else if (list[i] == '{') {
                flag = list[list.length - 1 - i] == '}' ? true : false;
            } else {
                flag = list[i] == list[list.length - 1 - i] ? true : false;
            }
        }
        if (flag) {
            result.setIsBalanced(true);
        }
        return result;
    }
}
