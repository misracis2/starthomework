package Entity;

import Dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String username;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String password;

    public Post(PostRequestDto postRequestDto) {
        this.username = postRequestDto.getUsername();
        this.title = postRequestDto.getTitle();
        this.content = postRequestDto.getContents();
        this.password = postRequestDto.getPassword();
    }

}
