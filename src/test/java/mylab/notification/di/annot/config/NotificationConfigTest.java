package mylab.notification.di.annot.config;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import mylab.notification.di.annot.EmailNotificationService;
import mylab.notification.di.annot.NotificationManager;
import mylab.notification.di.annot.NotificationService;
import mylab.notification.di.annot.SmsNotificationService;

@SpringJUnitConfig
@ContextConfiguration(classes = NotificationConfig.class)
public class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    public void testNotificationManager() {

        // NotificationManager 생성 확인
        assertNotNull(notificationManager);

        // 이메일 서비스 검증
        NotificationService emailService = notificationManager.getEmailService();
        assertNotNull(emailService);

        EmailNotificationService email = (EmailNotificationService) emailService;
        assertEquals("smtp.gmail.com", email.getSmtpServer());
        assertEquals(587, email.getPort());

        // SMS 서비스 검증
        NotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService);

        SmsNotificationService sms = (SmsNotificationService) smsService;
        assertEquals("SKT", sms.getProvider());

        // NotificationManager 메서드 실행
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}