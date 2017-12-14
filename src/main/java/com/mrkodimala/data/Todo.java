package com.mrkodimala.data;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Todo")
public class Todo {

    @Id
    String id;

    @Indexed(unique = true,background = true)
    String todoName;

    Date createTime;

    Date deliveryTime;
}
