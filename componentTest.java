import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import FeedbackForm from './component';

describe('FeedbackForm', () => {
  it('Submitting feedback with a rating and comment calls the onSubmit function with the correct values', () => {
    const onSubmit = jest.fn();
    render(<FeedbackForm onSubmit={onSubmit} />);

    // Select a rating (e.g., 4 stars)
    const star4 = screen.getAllByText('★')[3]; // Assuming stars are rendered in order
    fireEvent.click(star4);

    // Enter a comment
    const commentTextarea = screen.getByPlaceholderText('Leave a comment...');
    fireEvent.change(commentTextarea, { target: { value: 'This session was great!' } });

    // Submit the form
    const submitButton = screen.getByText('Submit Feedback');
    fireEvent.click(submitButton);

    // Assert that onSubmit was called with the correct rating and comment
    expect(onSubmit).toHaveBeenCalledTimes(1);
    expect(onSubmit).toHaveBeenCalledWith(4, 'This session was great!');

    // Assert that rating and comment are reset after submission
    //screen.debug(); // Uncomment to inspect the DOM if needed
  });
});