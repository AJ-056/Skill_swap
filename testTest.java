import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import FeedbackForm from './FeedbackForm';


describe('FeedbackForm', () => {
  it('submits the correct rating and comment when a star is clicked and a comment is entered', () => {
    const onSubmit = jest.fn();

    render(<FeedbackForm onSubmit={onSubmit} />);

    // Click the 4th star
    const stars = screen.getAllByText('★');
    fireEvent.click(stars[3]);

    // Enter a comment
    const commentTextarea = screen.getByPlaceholderText('Leave a comment...');
    fireEvent.change(commentTextarea, { target: { value: 'This session was great!' } });

    // Click the submit button
    const submitButton = screen.getByText('Submit Feedback');
    fireEvent.click(submitButton);

    // Assert that onSubmit was called with the correct rating and comment
    expect(onSubmit).toHaveBeenCalledTimes(1);
    expect(onSubmit).toHaveBeenCalledWith(4, 'This session was great!');
  });
});