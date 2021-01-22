package com.discord.faq_bot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomCommand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String identifier;

    private String Message;

    private long owner;

    private boolean multiWord;

    public CustomCommand() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public long getOwner() {
        return owner;
    }

    public void setOwner(long owner) {
        this.owner = owner;
    }

    public boolean isMultiWord() {
        return multiWord;
    }

    public void setMultiWord(boolean multiWord) {
        this.multiWord = multiWord;
    }

    public CustomCommand(String identifier, String message, long owner, boolean multiWord) {
        this.identifier = identifier;
        Message = message;
        this.owner = owner;
        this.multiWord = multiWord;
    }

    @Override
    public String toString() {
        return "CustomCommand{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", Message='" + Message + '\'' +
                ", owner=" + owner +
                '}';
    }
}
