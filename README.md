@"
# AI Security Gandalf — Prompt Injection Basics

Reference game: https://gandalf.lakera.ai
Built by: Lakera AI (LLM security company)

## What is this repo?
Hands-on exploration of prompt injection through the Gandalf game, plus my own
mini project demonstrating both the attack and basic defenses.

## Workflow Checklist
- [x] 1. Research — problem, creator, prerequisite concepts
- [ ] 2. Setup — play through levels
- [ ] 3. Architecture — N/A (hosted game, no local code) — study defense patterns instead
- [ ] 4. Experiments — level-by-level attack log
- [ ] 5. Deeper reading — prompt injection papers/blogs
- [ ] 6. Build — my own project (hidden-secret chatbot + defenses)
- [ ] 7. Medium article
- [ ] 8. Push final version to GitHub

## Folder Structure
- ``notes/`` — concept notes + level-by-level attack log
- ``experiments/`` — patterns found across levels, what attack types work
- ``my-project/`` — my own chatbot with a hidden secret + defenses I built
- ``reference/`` — notes on Gandalf's own approach (no installable code exists)

## What is Prompt Injection?
When crafted input tricks an AI into ignoring its original instructions and
doing something else instead — e.g. revealing a secret it was told to protect.

## Why This Matters
Any product with an LLM facing real users (chatbots, coding assistants, support
bots) needs to defend against this. Learning the attack side first builds the
instinct needed to design real defenses later.
"@ | Out-File -FilePath README.md -Encoding utf8