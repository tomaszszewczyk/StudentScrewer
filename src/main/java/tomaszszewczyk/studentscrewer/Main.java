package tomaszszewczyk.studentscrewer;

import tomaszszewczyk.studentscrewer.questions.ClosedQuestion;
import tomaszszewczyk.studentscrewer.questions.IQuestion;
import tomaszszewczyk.studentscrewer.questions.OpenQuestion;
import tomaszszewczyk.studentscrewer.summaries.ISummary;
import tomaszszewczyk.studentscrewer.summaries.StandardMarkStrategy;
import tomaszszewczyk.studentscrewer.summaries.StandardSummary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private JFrame frame;
    private JList list;
    private JButton button_add;
    private JButton button_remove;
    private JButton button_up;
    private JButton button_down;
    private JButton button_check;
    private JTextArea text;
    private DefaultListModel listModel;

    private List<IQuestion> questions;

    public static void main(String[] args) {
        Main app = new Main();
        app.init();
    }

    private void init() {
        questions = new ArrayList<>();

        frame = new JFrame("Student Screwer");

        listModel = new DefaultListModel();

        list = new JList(listModel);
        list.setBounds(10, 10, 480, 550);

        button_add = new JButton("Add");
        button_add.addActionListener(new ButtonAddAction());
        button_add.setBounds(30, 570, 80, 20);

        button_remove = new JButton("Del");
        button_remove.addActionListener(new ButtonDelAction());
        button_remove.setBounds(120, 570, 80, 20);

        button_up = new JButton("Up");
        button_up.addActionListener(new ButtonUpAction());
        button_up.setBounds(210, 570, 80, 20);

        button_down = new JButton("Down");
        button_up.addActionListener(new ButtonDownAction());
        button_down.setBounds(300, 570, 80, 20);

        button_check = new JButton("Check");
        button_check.addActionListener(new ButtonCheckAction());
        button_check.setBounds(390, 570, 80, 20);

        text = new JTextArea();
        text.setBounds(510, 10, 480, 580);
        text.setEditable(false);

        frame.add(text);
        frame.add(list);
        frame.add(button_add);
        frame.add(button_remove);
        frame.add(button_up);
        frame.add(button_down);
        frame.add(button_check);

        frame.setSize(1000, 630);
        frame.setLayout(null);
        frame.setVisible(true);

        EventQueue.invokeLater(() -> {
        });
    }

    private void updateView() {
        listModel.clear();
        for (IQuestion question : questions)
            listModel.addElement(question.getOneLiner());

        String result = "";
        int i = 1;
        for (IQuestion question : questions)
            result = String.format("%s%d. %s\n\n", result, i++, question.getText());

        text.setText(result);
    }

    private class ButtonAddAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            AddDialog addDialog = new AddDialog();
            addDialog.display();

            if (addDialog.isCanceled()) return;

            if (addDialog.isOptionsEmpty()) {
                OpenQuestion open_question = new OpenQuestion();
                open_question.setNoPoints(Integer.parseInt(addDialog.getPoints()));
                open_question.addContent(addDialog.getQuestion());
                open_question.addAnswer(addDialog.getAnswer());
                questions.add(open_question);
            } else {
                ClosedQuestion closed_question = new ClosedQuestion();

                closed_question.setNoPoints(Integer.parseInt(addDialog.getPoints()));
                closed_question.addContent(addDialog.getQuestion());
                for (String option : addDialog.getOptions())
                    closed_question.addPossibleAnswer(option);
                closed_question.addAnswer(addDialog.getAnswer());
                questions.add(closed_question);
            }

            updateView();
        }
    }

    private class ButtonDelAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int index = list.getSelectedIndex();

            if (index > 0 && index < questions.size())
                questions.remove(index);

            updateView();
        }
    }

    private class ButtonUpAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int index = list.getSelectedIndex();

            if (index > 0) {
                Collections.swap(questions, index, index - 1);
            }

            updateView();
        }
    }

    private class ButtonDownAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int index = list.getSelectedIndex();

            if (index < questions.size() - 1 && index >= 0) {
                Collections.swap(questions, index, index + 1);
            }

            updateView();
        }
    }

    private class ButtonCheckAction extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            int index = 1;
            ISummary summary = new StandardSummary();
            for (IQuestion question : questions) {
                CheckDialog check_dialog = new CheckDialog(index++);
                check_dialog.display();
                question.checkAnswer(check_dialog.getAnswer(), summary);
            }

            ResultDialog dialog = new ResultDialog(summary.getPercent(), summary.getMark(new StandardMarkStrategy()));
            dialog.display();
        }
    }
}