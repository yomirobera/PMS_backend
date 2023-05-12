package com.example.pms.mappers;

import com.example.pms.models.Chat;
import com.example.pms.models.User;
import com.example.pms.models.dto.chat.ChatDTO;

import com.example.pms.models.dto.chat.ChatPostDTO;
import com.example.pms.models.dto.chat.ChatUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ChatMapper {
    @Mapping(target = "users", source = "users", qualifiedByName = "usersToIds")
    public abstract ChatDTO chatToChatDTO(Chat chat);
    public abstract Collection<ChatDTO> chatToChatDTO(Collection<Chat> chats);
    public abstract Chat chatUpdateDtoToChat(ChatUpdateDTO chatDTO);
    public abstract Chat chatPostDtoToChat(ChatPostDTO chatDto);

    @Named("usersToIds")
    Set<String> map(Set<User> source) {
        if (source == null) return null;
        return source.stream().map(p -> p.getId()
        ).collect(Collectors.toSet());
    }
}
