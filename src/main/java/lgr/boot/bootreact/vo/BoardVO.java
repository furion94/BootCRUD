package lgr.boot.bootreact.vo;

import lombok.*;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@Entity(name = "TESTBOARD")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@ToString
@Alias("BVO")
public class BoardVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer board_number;

    @Column
    private String writer;
    @Column
    private String title;
    @Column
    private String content;
}


