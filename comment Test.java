import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import FeedbackForm from './FeedbackForm';

describe('FeedbackForm', () => {
  it('Changing the text in the textarea updates the comment state', () => {
    const onSubmit = jest.fn();
    render(<FeedbackForm onSubmit={onSubmit} />);

    const textareaElement = screen.getByPlaceholderText('Leave a comment...') as HTMLTextAreaElement;
    fireEvent.change(textareaElement, { target: { value: 'This is a test comment.' } });

    expect(textareaElement.value).toBe('This is a test comment.');

    const submitButton = screen.getByText('Submit Feedback');
    fireEvent.click(submitButton);

    expect(onSubmit).toHaveBeenCalledWith(0, 'This is a test comment.'); // Assuming initial rating is 0
  });
});