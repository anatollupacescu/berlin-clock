package com.test;

public interface TextRenderer<O, W> {

    void render(O object, W output);
}
