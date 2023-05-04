package com.example.pms.services.chat;

import com.example.pms.models.Chat;
import com.example.pms.repositories.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ChatServiceImpl implements ChatService {

    private final ChatRepository chatRepository;

    public ChatServiceImpl(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public Chat findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    public Chat add(Chat entity) {
        return null;
    }

    @Override
    public Chat update(Chat entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public boolean exists(Integer integer) {
        return false;
    }
}
