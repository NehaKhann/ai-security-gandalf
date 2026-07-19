# Reference — Understanding How Gandalf Works

Gandalf is a hosted AI security challenge created by Lakera. Its source code is **not publicly available**, so this folder contains notes based on Lakera's published articles and documentation rather than reverse-engineered or cloned code.

The goal of these notes is to understand the design principles behind Gandalf and compare them with the simplified defenses implemented in this project.

**Primary reference:**
- https://www.lakera.ai/blog/who-is-gandalf

---

## Core Components

According to Lakera's public write-up, every Gandalf level is built around three main components:

1. **System Prompt** – hidden instructions provided to the language model.
2. **Input Guard** – validates the user's prompt before it reaches the model.
3. **Output Guard** – validates the model's response before it is shown to the user.

This closely matches the architecture used in this project:

- System Prompt
- Input Filter
- Output Filter

While my implementation is intentionally much simpler, the overall mental model is the same.

---

## How the Defenses Become Stronger

Lakera explains that Gandalf gradually increases its defenses as players progress through the levels.

The public documentation describes a progression similar to:

- **Early levels** rely primarily on prompt instructions telling the model not to reveal the password.
- **Later levels** introduce input and output guards to inspect prompts and responses.
- **Advanced levels** move beyond simple keyword matching and use additional LLM-based classifiers to reason about user intent and whether a response indirectly leaks the secret.

Lakera also notes that even these more advanced defenses are not perfect, highlighting how difficult prompt injection remains as a security problem.

---

## Comparing with This Project

This repository intentionally implements a much simpler version of those ideas.

| This Project | Purpose |
|--------------|---------|
| Level 0 | No protection |
| Level 1 | System prompt only |
| Level 2 | Output filter (exact string matching) |
| Level 3 | Input filter (keyword matching) |

The goal was **not** to recreate Gandalf, but to understand how each defense behaves and where its limitations become apparent.

One natural next experiment would be replacing the keyword-based input filter with an LLM-based classifier that evaluates the intent of a prompt rather than matching specific words.

---

## Common Prompt Injection Patterns

Lakera's articles and other public discussions describe several common categories of prompt injection attacks.

Examples include:

- **Encoding or obfuscation** – reversing, translating, spelling out, or otherwise transforming sensitive information.
- **Indirect requests** – asking for hints, rhymes, associations, or descriptions instead of requesting the secret directly.
- **Structured outputs** – hiding sensitive information inside poems, stories, acronyms, or other generated formats.
- **Role or authority changes** – asking the model to assume a different identity or ignore previous instructions.

These examples are included to understand common attack patterns—not as instructions for bypassing security.

---

## Why This Matters

One of the biggest lessons from Gandalf is that manually trying a handful of prompts is **not enough** to evaluate an AI system's security.

Lakera reported millions of interactions with Gandalf shortly after launch, demonstrating how many different ways people naturally attempt to bypass AI safeguards.

My own testing involved only a small number of manually written prompts. That was enough to understand the strengths and weaknesses of each defense layer, but it is **not** sufficient to measure security comprehensively.

That is why automated AI security evaluation tools such as **Garak**, **PyRIT**, and **JailbreakBench** exist—they systematically generate and evaluate large numbers of adversarial prompts to uncover weaknesses that manual testing is likely to miss.

---

## Sources

- https://www.lakera.ai/blog/who-is-gandalf
- https://www.lakera.ai/blog/gandalf-the-red-rethinking-llm-security-with-adaptive-defenses
- https://gandalf.lakera.ai/pinj