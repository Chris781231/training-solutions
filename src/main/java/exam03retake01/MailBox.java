package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public List<Mail> findByCriteria(String criteria) {
        if (criteria == null || criteria.equals("")) {
            throw new IllegalArgumentException("criteria is must not be empty");
        }
        if (criteria.startsWith("from:")) {
            return getMailsByFrom(criteria);
        } else if (criteria.startsWith("to:")) {
            return getMailsByTo(criteria);
        } else {
            return getMailsBySubjectOrMessage(criteria);
        }
    }

    private List<Mail> getMailsBySubjectOrMessage(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getSubject().contains(criteria) || mail.getMessage().contains(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> getMailsByTo(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            for (Contact to : mail.getTo()) {
                if (criteria.contains(to.getName()) || criteria.contains(to.getEmail())) {
                    result.add(mail);
                }
            }
        }
        return result;
    }

    private List<Mail> getMailsByFrom(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (criteria.contains(mail.getFrom().getName()) || criteria.contains(mail.getFrom().getEmail())) {
                result.add(mail);
            }
        }
        return result;
    }


    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return new ArrayList<>(mails);
    }
}
