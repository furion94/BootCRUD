package lgr.boot.bootreact.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "TESTBOARD")
@Data
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
