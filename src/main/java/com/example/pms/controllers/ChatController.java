package com.example.pms.controllers;

import com.example.pms.mappers.ChatMapper;
import com.example.pms.models.Chat;
import com.example.pms.models.dto.chat.ChatUpdateDTO;
import com.example.pms.models.dto.chat.ChatPostDTO;
import com.example.pms.models.dto.chat.ChatUpdateDTO;
import com.example.pms.services.chat.ChatService;
import com.example.pms.utils.error.ApiErrorResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/chat")
public class ChatController {

    private final ChatService chatService;
    private final ChatMapper chatMapper;

    public ChatController(ChatService chatService, ChatMapper chatMapper) {
        this.chatService = chatService;
        this.chatMapper = chatMapper;
    }

    @Operation(summary = "Get all chats")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Chat.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content ={ @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Chats not found",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping
    public ResponseEntity getAll() {
        return ResponseEntity.ok(chatMapper.chatToChatDTO(chatService.findAll()));
    }
    @Operation(summary = "Get a chat by id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "200",
                    description = "Success",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Chat.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Chat not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) {
        return ResponseEntity.ok(chatMapper.chatToChatDTO(chatService.findById(id)));
    }
    @Operation(summary = "Updates a chat")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Chat is successfully updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Chat.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Chat was not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PutMapping("{id}")
    public ResponseEntity update(@RequestBody ChatUpdateDTO chatDTO, @PathVariable int id) {
        // Validates if body is correct
        if (id != (chatDTO.getId()))
            return ResponseEntity.badRequest().build();

        chatService.update(chatMapper.chatUpdateDtoToChat(chatDTO));
        return ResponseEntity.noContent().build();
    }
    @Operation(summary = "Adds new chat")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201",
                    description = "Chat was successfully added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Chat.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Chat was not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @PostMapping
    public ResponseEntity add(@RequestBody ChatPostDTO chatDto) {
        Chat chat = chatService.add(chatMapper.chatPostDtoToChat(chatDto));
        URI location = URI.create("chats/" + chat.getId());
        return ResponseEntity.created(location).build();
    }
    @Operation(summary = "Deletes an existing chat by id")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "204",
                    description = "Chat is successfully deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Chat.class)) }),
            @ApiResponse(responseCode = "400",
                    description = "Malformed request",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) }),
            @ApiResponse(responseCode = "404",
                    description = "Chat was not found with supplied ID",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ApiErrorResponse.class)) })
    })
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable int id) {
        chatService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
