package com.phoenixsquad.driveprep_server.service.implementation;

import com.phoenixsquad.driveprep_server.model.Question;
import com.phoenixsquad.driveprep_server.repository.QuestionRepository;
import com.phoenixsquad.driveprep_server.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Implementation of the QuestionService interface.
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public List<Question> getQuestions(Integer categoryId, Integer complexityLevel, Integer themeId, Date dateAdded) {
        if(categoryId != null)
            return getQuestionsFromAllThemes(categoryId, complexityLevel, dateAdded);
        else if(themeId != null)
            return getQuestionsFromSpecificTheme(themeId, complexityLevel, dateAdded);

        return getAllQuestions();
    }

    private List<Question> getQuestionsFromAllThemes(Integer categoryId, Integer complexityLevel, Date dateAdded) {
        if(categoryId != null && complexityLevel != null && dateAdded != null)
            return getQuestionsByCategoryAndComplexityAndDateAdded(categoryId, complexityLevel, dateAdded);
        else if(categoryId != null && complexityLevel != null)
            return getQuestionsByCategoryAndComplexity(categoryId, complexityLevel);
        else if(categoryId != null && dateAdded != null)
            return getQuestionsByCategoryAndDateAdded(categoryId, dateAdded);
        else
            return getQuestionsByCategory(categoryId);
    }

    private List<Question> getQuestionsFromSpecificTheme(Integer themeId, Integer complexityLevel, Date dateAdded) {
        if (themeId != null && complexityLevel != null && dateAdded != null)
            return getQuestionsByThemeAndComplexityAndDateAdded(themeId, complexityLevel, dateAdded);
        else if (themeId != null && complexityLevel != null)
            return getQuestionsByThemeAndComplexity(themeId, complexityLevel);
        else if (themeId != null && dateAdded != null)
            return getQuestionsByThemeAndDateAdded(themeId, dateAdded);
        else
            return getQuestionsByTheme(themeId);
    }

    @Override
    public List<Question> getAllQuestions() {
        Iterable<Question> questions = questionRepository.findAll();
        return StreamSupport.stream(questions.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public List<Question> getQuestionsByCategory(Integer categoryId) {
        return questionRepository.getQuestionsByCategory(categoryId);
    }

    @Override
    public List<Question> getQuestionsByCategoryAndComplexity(Integer categoryId, Integer complexityLevel) {
        ComplexityLevel level = ComplexityLevel.values()[complexityLevel - 1];
        int minComplexity = level.getMinComplexity();
        int maxComplexity = level.getMaxComplexity();

        return questionRepository.getQuestionsByCategoryAndComplexity(categoryId, minComplexity, maxComplexity);
    }

    @Override
    public List<Question> getQuestionsByCategoryAndDateAdded(Integer categoryId, Date dateAdded) {
        return questionRepository.getQuestionsByCategoryAndDateAdded(categoryId, dateAdded);
    }

    @Override
    public List<Question> getQuestionsByCategoryAndComplexityAndDateAdded(
            Integer categoryId,
            Integer complexityLevel,
            Date dateAdded)
    {
        ComplexityLevel level = ComplexityLevel.values()[complexityLevel - 1];
        int minComplexity = level.getMinComplexity();
        int maxComplexity = level.getMaxComplexity();

        return questionRepository.getQuestionsByCategoryAndComplexityAndDateAdded(categoryId, minComplexity,
                maxComplexity, dateAdded);
    }

    @Override
    public List<Question> getExamQuestionsByCategory(Integer categoryId) {
        return questionRepository.getExamQuestionsByCategory(categoryId);
    }

    @Override
    public List<Question> getExamQuestionsByCategoryAndComplexity(Integer categoryId, Integer complexityLevel) {
        ComplexityLevel level = ComplexityLevel.values()[complexityLevel - 1];
        int minComplexity = level.getMinComplexity();
        int maxComplexity = level.getMaxComplexity();

        return questionRepository.getExamQuestionsByCategoryAndComplexity(categoryId, minComplexity, maxComplexity);
    }

    @Override
    public List<Question> getQuestionsByTheme(Integer themeId) {
        return questionRepository.getQuestionsByTheme(themeId);
    }

    @Override
    public List<Question> getQuestionsByThemeAndComplexity(Integer themeId, Integer complexityLevel) {
        ComplexityLevel level = ComplexityLevel.values()[complexityLevel - 1];
        int minComplexity = level.getMinComplexity();
        int maxComplexity = level.getMaxComplexity();

        return questionRepository.getQuestionsByThemeAndComplexity(themeId, minComplexity, maxComplexity);
    }

    @Override
    public List<Question> getQuestionsByThemeAndDateAdded(Integer themeId, Date dateAdded) {
        return questionRepository.getQuestionsByThemeAndDateAdded(themeId, dateAdded);
    }

    @Override
    public List<Question> getQuestionsByThemeAndComplexityAndDateAdded(
            Integer themeId,
            Integer complexityLevel,
            Date dateAdded)
    {
        ComplexityLevel level = ComplexityLevel.values()[complexityLevel - 1];
        int minComplexity = level.getMinComplexity();
        int maxComplexity = level.getMaxComplexity();

        return questionRepository.getQuestionsByThemeAndComplexityAndDateAdded(themeId, minComplexity, maxComplexity,
                dateAdded);
    }

    enum ComplexityLevel {
        LEVEL_1(1, 15),
        LEVEL_2(16, 30),
        LEVEL_3(31, 50),
        LEVEL_4(51, 100);

        private final int minComplexity;
        private final int maxComplexity;

        ComplexityLevel(int minComplexity, int maxComplexity) {
            this.minComplexity = minComplexity;
            this.maxComplexity = maxComplexity;
        }

        public int getMinComplexity() {
            return minComplexity;
        }

        public int getMaxComplexity() {
            return maxComplexity;
        }
    }

}