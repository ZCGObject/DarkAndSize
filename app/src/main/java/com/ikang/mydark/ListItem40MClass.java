package com.ikang.mydark;

class ListItem40MClass {

    byte[] content = new byte[1000 * 1000 * 40];
    ListItem40MClass() {
        for (int i = 0; i < content.length; i++) {
            content[i] = 1;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    ListItem40MClass next;
}
