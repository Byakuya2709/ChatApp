/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.message;

/**
 *
 * @author admin
 */
public class TextMessage implements message {
    private final String content;

    public TextMessage(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return content;
    }
    
}
