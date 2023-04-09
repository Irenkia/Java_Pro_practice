package com.example.practice5new;

import jakarta.validation.constraints.Size;
public class Quote {
    @Size(max = 20, message = "Size should be max 20 chars")
    private String quote;

    public String getQuote()
    {
        return quote;
    }

    public void setQuote(String quote)
    {
        this.quote = quote;
    }
}
