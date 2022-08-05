package ru.skillfactorydemo.tgbot.entity;

import lombok.Data;

import javax.persistence.*;

@Data  //Для того, чтобы не писать геттеры/сеттеры
@Entity // Данный класс является JPA сущностью
@Table(name = "active_chat") //И хранится в таблице ACTIVE_CHAT
public class ActiveChat {

    @Id
    @GeneratedValue
    private Long id; //Уникальный идентификатор в системе нашего бота

    @Column(name = "chat_id")
    private Long chatId; //Уникальный идентификатор в системе Telegram
}
