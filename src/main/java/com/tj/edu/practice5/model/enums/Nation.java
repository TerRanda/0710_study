package com.tj.edu.practice5.model.enums;

public enum Nation {
    //값 미지정 시, 0번~숫자로 결과값이 나옴.
    KOREA(1),
    JAPAN(2),
    CHINA(3),
    ENGLAND(4),
    기타(5);

    //숫자 value값 지정해주는 방법
    //getValue 활용.
    private final int value;
    Nation(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
