package com.yonghyeon.ntsproject.service;

import com.yonghyeon.ntsproject.dto.PostUpdateRequest;
import com.yonghyeon.ntsproject.exception.NotFoundException;
import com.yonghyeon.ntsproject.repository.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;


    @Test
    public void modifyTest() {
        Mockito.when(postRepository.exist(anyLong())).thenReturn(false);

        PostUpdateRequest postUpdateRequest = new PostUpdateRequest(anyLong(), "testTitle", "testContent");
        assertThrows(NotFoundException.class, () -> {
            postService.modify(postUpdateRequest);
        });
    }

    @Test
    public void removeTest() {
        Mockito.when(postRepository.exist(anyLong())).thenReturn(false);

        assertThrows(NotFoundException.class, () -> {
            postService.remove(anyLong());
        });
    }
}
